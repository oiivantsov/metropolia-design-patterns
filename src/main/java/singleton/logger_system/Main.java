package singleton.logger_system;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.setFileName("src/main/java/singleton/logger_system/new_log.txt"); // Change file name
        logger.write("Simulation started");
        logger.write("Processing data...");
        logger.write("Simulation finished");
        logger.close(); // Remember to close the logger

        logger.write("This message will not be logged"); // This message will not be logged

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                Logger logger = Logger.getInstance();
                logger.setFileName("src/main/java/singleton/logger_system/new_log.txt"); // Change file name
                logger.write("Thread 1 is running");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                Logger logger = Logger.getInstance();
                logger.setFileName("src/main/java/singleton/logger_system/new_log.txt"); // Change file name
                logger.write("Thread 2 is running");
            }
        });

        t1.start();
        t2.start();
    }
}

