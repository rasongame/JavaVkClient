package JavaVkClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountInfoFrame extends JFrame implements ActionListener {
    JLabel first_name, last_name, status;

    public AccountInfoFrame() {
        super("Account info");
        first_name = new JLabel(VkAccountManager.getInstance().first_name);
        last_name = new JLabel(VkAccountManager.getInstance().last_name);
        status = new JLabel(VkAccountManager.getInstance().status);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        AccountName
        setLayout(null);
        first_name.setBounds(50, 100, 200,30);
        last_name.setBounds(50, 140, 200,30);
        first_name.setHorizontalAlignment(SwingConstants.LEFT);
        last_name.setHorizontalAlignment(SwingConstants.LEFT);

//        status.setBounds(50, 100, 200,30);
        add(first_name);
        add(last_name);
        add(status);

        setSize(new Dimension(400,400));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
