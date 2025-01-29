package chain_of_responsibility.feedback_handler;

public class CompensationClaimHandler extends Handler {

    @Override
    public void handleMessage(Message message) {
        if (message.getMessageType() == MessageType.COMPENSATION_CLAIM) {
            System.out.println("Compensation Claim Handler | Handling Compensation Claim: " + message.getContent());
        } else {
            System.out.println("Compensation Claim Handler | Cannot handle. Sending to next handler.");
            super.handleMessage(message);
        }
    }
}

