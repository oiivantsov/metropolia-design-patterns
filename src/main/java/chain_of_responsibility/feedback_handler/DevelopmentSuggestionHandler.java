package chain_of_responsibility.feedback_handler;

public class DevelopmentSuggestionHandler extends Handler {

    @Override
    public void handleMessage(Message message) {
        if (message.getMessageType() == MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("Development Suggestion Handler | Logging and prioritizing development suggestion: " + message.getContent());
        } else {
            System.out.println("Development Suggestion Handler | Cannot handle. Sending to next handler.");
            super.handleMessage(message);
        }
    }
}
