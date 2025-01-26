package singleton.logger_system;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    // we use volatile keyword to ensure that multiple threads offer the instance variable correctly
    private static volatile Logger instance;
    private PrintWriter writer;

    private Logger() {}

    // lazy initialization, double-checked locking for thread-safe Singleton
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // write a log message
    public synchronized void write(String message) {
        try {
            if (writer == null) {
                throw new IllegalStateException("Logger is not initialized. Call setFileName() first.");
            }
            writer.println(message);
            writer.flush();
        } catch (Exception e) {
            System.err.println("Failed to write to log file: " + e.getMessage());
        }
    }

    // set a new log file name
    public synchronized void setFileName(String fileName) {
        close(); // close the current file before opening a new one
        openFile(fileName);
    }

    // close the current file
    public synchronized void close() {
        if (writer != null) {
            writer.close();
            writer = null;
        }
    }

    // open a log file
    private void openFile(String fileName) {
        try {
            writer = new PrintWriter(new FileWriter(fileName, true)); // append mode
        } catch (IOException e) {
            System.err.println("Failed to open log file: " + e.getMessage());
        }
    }
}

