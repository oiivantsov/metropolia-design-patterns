package observer.youtube_example;

public interface Observer {
    void update();

    void subscribeChannel(Channel channel);

    void unsubscribeChannel();
}
