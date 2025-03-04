package mediator.chat_app;

import java.util.HashMap;
import java.util.Map;

// very similar to controller in MVC
public class ChatMediatorImpl implements ChatMediator {
    private final Map<String, ChatClient> clients = new HashMap<>();

    @Override
    public void registerClient(ChatClient client) {
        clients.put(client.getUsername(), client);
    }

    @Override
    public void sendMessage(String sender, String recipient, String message) {
        if (clients.containsKey(recipient)) {
            clients.get(recipient).receiveMessage(sender, message);
        }
    }
}
