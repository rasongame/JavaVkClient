package JavaVkClient.Components;

import javax.swing.*;

public class ChatButton extends JButton {
    public boolean chatButton = true;
    private JLabel button;

    public ChatButton(String label) {
        super(label);
    }

    private long chat_id;

    public void setChat_id(long chat_id) {
        this.chat_id = chat_id;
    }

    public long getChat_id() {
        return chat_id;

    }


}
