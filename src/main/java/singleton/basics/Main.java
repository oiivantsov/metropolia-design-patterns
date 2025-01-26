package singleton.basics;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                Abc obj = Abc.getInstance3();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                Abc obj = Abc.getInstance3();
            }
        });

        t1.start();
        t2.start();

        // deserialization

    }
}
