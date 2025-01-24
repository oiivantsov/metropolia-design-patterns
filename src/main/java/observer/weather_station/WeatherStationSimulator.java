package observer.weather_station;

public class WeatherStationSimulator {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation(-10, 40);

        WeatherObserver observer1 = new WeatherObserver("Web Observer");
        WeatherObserver observer2 = new WeatherObserver("Mobile Observer");
        WeatherObserver observer3 = new WeatherObserver("Desktop Observer");

        weatherStation.registerObserver(observer1);
        weatherStation.registerObserver(observer2);
        weatherStation.registerObserver(observer3);

        Thread weatherStationThread = new Thread(weatherStation);
        weatherStationThread.start();

        // Pause main thread for 10 seconds to simulate the weather station running
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Remove one observer and continue the simulation
        System.out.println("Removing " + observer2 + "...");
        weatherStation.removeObserver(observer2);

        try {
            Thread.sleep(10000); // Run for another 10 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Stop the weather station
        weatherStation.stop();
        try {
            weatherStationThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Weather station simulation ended.");
    }
}
