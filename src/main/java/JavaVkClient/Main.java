package JavaVkClient;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        VkAccountManager vk = VkAccountManager.getInstance();

        javax.swing.SwingUtilities.invokeLater(() -> {
//                createGUI();

            var authwindow = new AuthWindowFrame();
            var ChatBoxWindow = ChatBoxFrame.getInstance();
            var account_info_window = new AccountInfoFrame();
            JFrame.setDefaultLookAndFeelDecorated(true);
            authwindow.setVisible(true);
            ChatBoxWindow.setVisible(false);
            JFrame.setDefaultLookAndFeelDecorated(true);
            account_info_window.setVisible(false);
        });
    }
}
