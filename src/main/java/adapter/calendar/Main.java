package adapter.calendar;

public class Main {
    public static void main(String[] args) {
        NewDateInterface dateAdapter = new CalendarToNewDateAdapter();

        dateAdapter.setYear(2025);
        dateAdapter.setMonth(2);
        dateAdapter.setDay(12);

        System.out.println("Initial Date: " + dateAdapter.getDay() + "/" + dateAdapter.getMonth() + "/" + dateAdapter.getYear());

        // use the adapter to advance the date
        dateAdapter.advanceDays(10);

        System.out.println("New Date after advancing 10 days: " + dateAdapter.getDay() + "/" + dateAdapter.getMonth() + "/" + dateAdapter.getYear());
    }
}

