package JavaVkClient;

public class Main {
    public static void main(String[] args) {
        VkAccountManager vk = VkAccountManager.getInstance();

        javax.swing.SwingUtilities.invokeLater(() -> {
//                createGUI();

            new AuthWindowFrame().setVisible(true);
            ChatBoxFrame.getInstance().setVisible(false);
            new AccountInfoFrame().setVisible(false);
        });
    }
}
