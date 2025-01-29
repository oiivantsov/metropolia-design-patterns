package chain_of_responsibility.feedback_handler;

public class ContactRequestHandler extends Handler {

    @Override
    public void handleMessage(Message message) {
        if (message.getMessageType() == MessageType.CONTACT_REQUEST) {
            System.out.println("Contact Request Handler | Forwarding contact request to the relevant department: " + message.getContent());
        } else {
            System.out.println("Contact Request Handler | Cannot handle. Sending to next handler.");
            super.handleMessage(message);
        }
    }
}

