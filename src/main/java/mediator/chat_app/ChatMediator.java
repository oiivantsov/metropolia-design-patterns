package mediator.chat_app;

public interface ChatMediator {
    void registerClient(ChatClient client);
    void sendMessage(String sender, String recipient, String message);
}