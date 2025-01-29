package chain_of_responsibility.feedback_handler;

public class GeneralFeedbackHandler extends Handler {

    @Override
    public void handleMessage(Message message) {
        if (message.getMessageType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("General Feedback Handler | Analyzing and responding to general feedback: " + message.getContent());
        } else {
            System.out.println("General Feedback Handler | Cannot handle. Sending to next handler.");
            super.handleMessage(message);
        }
    }
}
