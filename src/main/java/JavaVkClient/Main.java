package JavaVkClient;

public class Main {
    public static void main(String[] args) {
        VkAccountManager vk = VkAccountManager.getInstance();

        javax.swing.SwingUtilities.invokeLater(() -> {
//                createGUI();

            new AuthWindowFrame();
        });
    }
}
