package chain_of_responsibility.feedback_handler;

public class Message {
    private MessageType messageType;
    private String content;
    private String senderEmail;

    public Message(MessageType messageType, String content, String senderEmail) {
        this.messageType = messageType;
        this.content = content;
        this.senderEmail = senderEmail;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public String getContent() {
        return content;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    @Override
    public String toString() {
        return "Message Type: " + messageType + "\nContent: " + content + "\nSender Email: " + senderEmail;
    }
}

