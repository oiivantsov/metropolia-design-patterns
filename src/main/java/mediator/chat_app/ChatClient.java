package mediator.chat_app;

import javafx.scene.control.*;


public class ChatClient {
    private final String username;
    private final ChatMediator mediator;
    private final TextArea chatArea;

    public ChatClient(String username, ChatMediator mediator, TextArea chatArea) {
        this.username = username;
        this.mediator = mediator;
        this.chatArea = chatArea;
        mediator.registerClient(this);
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage(String recipient, String message) {
        chatArea.appendText("You to " + recipient + ": " + message + "\n");
        mediator.sendMessage(username, recipient, message);
    }

    public void receiveMessage(String sender, String message) {
        chatArea.appendText(sender + ": " + message + "\n");
    }
}
