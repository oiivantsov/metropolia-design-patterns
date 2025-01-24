package observer.youtube_example;

public interface Subject {
    void subscribe(Subscriber subscriber);

    void unsubscribe(Subscriber subscriber);

    void notifySubscribers();
}
