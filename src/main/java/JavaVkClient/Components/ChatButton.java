package JavaVkClient.Components;

import java.awt.*;

public class ChatButton extends Component {
    private Button button;
    private long chat_id;

    public ChatButton(String label, long id) {
        button = new Button(label);
        chat_id = chat_id;

    }

    public long getChat_id() {
        return chat_id;
    }

    public Button getButton() {
        return button;
    }
}
