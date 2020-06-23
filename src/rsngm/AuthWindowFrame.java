package rsngm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AuthWindowFrame extends JFrame implements ActionListener {
    JTextField login_field;
    JButton login_btn;
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
        login_field.setBounds(50, 100, 200,30);
        login_btn.setBounds(50, 250, 200,30);
        add(info_label);
        add(login_field);
        add(login_btn);

        login_btn.addActionListener(this);
        setLayout(null);
        setSize(new Dimension(400,400));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == login_btn && !login_field.getText().isBlank()) {

            try {
                VkAccountManager.getInstance().login(login_field.getText());
//                setVisible(false);
                new AccountInfoFrame();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
