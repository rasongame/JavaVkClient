package JavaVkClient;

import JavaVkClient.Components.ChatButton;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ChatBoxFrame extends JFrame implements ActionListener {
    public static ChatBoxFrame instance;
    JTextField text_box;
    JButton send_btn;
    JTextField peer_id_box;
    JPanel chatPanel;
    JPanel anotherPanel;
    public ChatBoxFrame() {
        super("ChatBox");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        chatPanel = new JPanel();
        anotherPanel = new JPanel();
        text_box = new JTextField("text");
        peer_id_box = new JTextField("chat id");
        send_btn = new JButton("send");
        var layout = new GridLayout(1, 3);
        layout.setHgap(10);
        chatPanel.setLayout(layout);
        chatPanel.add(text_box);
        chatPanel.add(send_btn);
        chatPanel.add(peer_id_box);
        add(chatPanel, "North");
        add(anotherPanel, "South");
        send_btn.addActionListener(this);
        setSize(new Dimension(400, 400));
    }

    public static ChatBoxFrame getInstance() {
        if (instance == null) {
            instance = new ChatBoxFrame();
        }
        return instance;

    }

    public void addChats() throws IOException, InterruptedException {
        ArrayList<JSONObject> list = null;
        // Вызвать при открытии окна.
        try {
            list = VkAccountManager.getInstance().getChatList();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (list != null) {
            for (JSONObject object : list) {
                System.out.println("FFF");
                JSONObject conversation = (JSONObject) object.get("conversation");
                JSONObject peer = (JSONObject) conversation.get("peer");
                if (peer.get("type").equals("chat")) {
                    JSONObject chat_settings = (JSONObject) conversation.get("chat_settings");
                    ChatButton btn = new ChatButton((String) chat_settings.get("title"));
                    btn.setName("chat-" + peer.get("id"));
                    btn.setChat_id((Long) peer.get("id"));
                    btn.addActionListener(this);
                    anotherPanel.add(btn);
                } else if (peer.get("type").equals("user")) {
                    ChatButton btn = new ChatButton(String.valueOf(peer.get("id")));
                    btn.setChat_id((Long) peer.get("id"));
                    btn.addActionListener(this);
                    anotherPanel.add(btn);
                }

            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getSource() == send_btn) {
            System.out.println((send_btn.getText()));
            try {
                System.out.println("test");
                VkAccountManager.getInstance().sendMessage(peer_id_box.getText(), text_box.getText());
                addChats();
                System.out.println(VkAccountManager.getInstance().getUserInfo(367919273));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(actionEvent.getSource().getClass().getName());
        System.out.println(ChatButton.class.getName());
        if (actionEvent.getSource().getClass().getName().equals(ChatButton.class.getName())) {

            ChatButton button = (ChatButton) actionEvent.getSource();
            peer_id_box.setText(String.valueOf(button.getChat_id()));
            System.out.println("pizda");

        }
    }
}


