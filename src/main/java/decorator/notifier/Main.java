package decorator.notifier;

// Client code
public class Main {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier decoratedNotifier = new SMSNotifierDecorator(emailNotifier);

        // Client treats both the wrappee and the wrapper as Notifier
        decoratedNotifier.send("Hello, World!");
    }
}
