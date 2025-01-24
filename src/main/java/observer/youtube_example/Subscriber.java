package observer.youtube_example;

public class Subscriber implements Observer {

    private String name;
    private Channel channel;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println("Hey " + name + ", Video uploaded: " + channel.getTitle());
    }

    @Override
    public void subscribeChannel(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void unsubscribeChannel() {
        this.channel = null;
    }

    public String getName() {
        return name;
    }
}
