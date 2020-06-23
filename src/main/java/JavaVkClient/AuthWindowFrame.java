package JavaVkClient;

import JavaVkClient.Config.ConfigReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AuthWindowFrame extends JFrame implements ActionListener {
    JTextField login_field;
    JButton login_btn, skip_btn;
    JLabel info_label;

    public AuthWindowFrame() {
        super("Auth Window");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        info_label = new JLabel("Need a access token");
        info_label.setVerticalAlignment(SwingConstants.TOP);
        info_label.setHorizontalAlignment(SwingConstants.CENTER);
        info_label.setBounds(50, 70, 250, 30);
        login_field = new JTextField("Login");
        login_btn = new JButton("Login");
        skip_btn = new JButton("Skip");
        skip_btn.setBounds(50, 200, 200, 30);
        login_field.setBounds(50, 100, 200, 30);
        login_btn.setBounds(50, 250, 200, 30);
        add(info_label);
        add(skip_btn);
        add(login_field);
        add(login_btn);

        login_btn.addActionListener(this);
        skip_btn.addActionListener(this);
        setLayout(null);
        setSize(new Dimension(400,400));
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == login_btn && !login_field.getText().isBlank()) {

            try {
                VkAccountManager.getInstance().login(login_field.getText());
                setVisible(false);
                ChatBoxFrame.getInstance();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (actionEvent.getSource() == skip_btn) {
            try {
                var acc = ConfigReader.getInstance().getToken();
                System.out.println("SSSS: " + acc);
                VkAccountManager.getInstance().login(acc);
                setVisible(false);
                ChatBoxFrame.getInstance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
