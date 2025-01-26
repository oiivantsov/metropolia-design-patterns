package decorator.notifier;

// Wrapper (Decorator)
public class SMSNotifierDecorator implements Notifier {
    private Notifier wrappee; // The original object

    public SMSNotifierDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void send(String message) {
        wrappee.send(message); // Delegating to the wrappee
        sendSMS(message); // Adding additional behavior
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

