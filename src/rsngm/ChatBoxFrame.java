package rsngm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ChatBoxFrame extends JFrame implements ActionListener {
    JTextField text_box;
    JButton send_btn;
    JTextField peer_id_box;

    public ChatBoxFrame() {
        super("ChatBox");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        text_box = new JTextField("text");
        peer_id_box = new JTextField("chat id");
        send_btn = new JButton("send");
        send_btn.setBounds(50, 100, 200, 30);
        text_box.setBounds(50, 200, 200, 30);
        peer_id_box.setBounds(50, 150, 200, 30);
        add(text_box);
        add(send_btn);
        add(peer_id_box);
        setLayout(null);
        setSize(new Dimension(400, 400));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == send_btn) {
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

