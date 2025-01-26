package singleton.basics;

public class Abc {
    // volatile keyword is used to make sure that multiple threads handle the uniqueInstance variable correctly
    private volatile static Abc instance;

    private Abc() {}

    // 1st version: creates multiple instances if two thread
    // access this method simultaneously
    public static Abc getInstance1()
    {
        if (instance == null) {
            instance = new Abc();
        }

        return instance;
    }

    // 2nd version : this is thread-safe and only
    // creates one instance of Singleton on concurrent
    // environment but it is unnecessarily expensive due to
    // cost of synchronization at every call.
    public static synchronized Abc getInstance2()
    {
        if (instance == null) {
            instance = new Abc();
        }
        return instance;
    }

    // 3rd version : An implementation of double checked
    // locking of Singleton. Intention is to reduce cost
    // of synchronization and improve performance, by only
    // locking critical section of code, the code which
    // creates instance of Singleton class.
    public static Abc getInstance3()
    {
        if (instance == null) {
            synchronized (Abc.class)
            {
                if (instance == null) {
                    instance = new Abc();
                }
            }
        }
        return instance;
    }
}
