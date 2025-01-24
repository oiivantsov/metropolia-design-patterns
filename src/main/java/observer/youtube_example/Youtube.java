package observer.youtube_example;

public class Youtube {

    public static void main(String[] args) {
        Channel channel = new Channel();

        Subscriber subscriber1 = new Subscriber("Alice");
        subscriber1.subscribeChannel(channel);

        Subscriber subscriber2 = new Subscriber("Bob");
        subscriber2.subscribeChannel(channel);

        channel.subscribe(subscriber1);
        channel.subscribe(subscriber2);

        channel.upload("How to make a cake");

        subscriber1.unsubscribeChannel();
        channel.unsubscribe(subscriber1);
        channel.upload("How to make a pizza");
    }
}
