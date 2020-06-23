package JavaVkClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ChatBoxFrame extends JFrame implements ActionListener {
    public static ChatBoxFrame instance;
    JTextField text_box;
    JButton send_btn;
    JTextField peer_id_box;
    JPanel chatPanel;

    public ChatBoxFrame() {
        super("ChatBox");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        chatPanel = new JPanel();
        text_box = new JTextField("text");
        peer_id_box = new JTextField("chat id");
        send_btn = new JButton("send");
        chatPanel.setBounds(100, 200, 200, 200);
        send_btn.setBounds(0, 100, 200, 30);
        text_box.setBounds(0, 200, 200, 30);
        peer_id_box.setBounds(0, 150, 200, 30);
        chatPanel.add(text_box);
        chatPanel.add(send_btn);
        chatPanel.add(peer_id_box);
        add(chatPanel);
        send_btn.addActionListener(this);
        setLayout(null);
        setSize(new Dimension(400, 400));
        setVisible(true);
    }

    public static ChatBoxFrame getInstance() {
        if (instance == null) {
            instance = new ChatBoxFrame();
        }
        return instance;

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == send_btn) {
            System.out.println((send_btn.getText()));
            try {
                System.out.println("test");
                VkAccountManager.getInstance().sendMessage(peer_id_box.getText(), text_box.getText());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

