package observer.weather_station;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class WeatherStation implements Runnable, Subject {
    private final List<Observer> observers;
    private int temperature;
    private final int minTemperature;
    private final int maxTemperature;
    private final Random random;
    private boolean running;

    public WeatherStation(int minTemperature, int maxTemperature) {
        this.observers = new ArrayList<>();
        this.random = new Random();
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.temperature = random.nextInt(maxTemperature - minTemperature + 1) + minTemperature;
        this.running = true;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public  void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
        System.out.println("** ------------------- **");
    }

    @Override
    public void run() {
        while (running) {
            try {
                // temperature change
                int change = random.nextBoolean() ? 1 : -1;
                temperature = Math.max(minTemperature, Math.min(maxTemperature, temperature + change));

                // Notify observers of the temperature change
                notifyObservers();

                // Sleep for a random time between 1-5 seconds
                Thread.sleep((random.nextInt(5) + 1) * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Weather station thread interrupted.");
                break;
            }
        }
    }

    public void stop() {
        running = false;
    }
}

