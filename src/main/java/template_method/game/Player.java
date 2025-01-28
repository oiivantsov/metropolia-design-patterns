package template_method.game;

// track individual scores and times
class Player {
    private final String name;
    private double averageTime; // average typing time per word

    public Player(String name) {
        this.name = name;
        this.averageTime = 0;
    }

    public String getName() {
        return name;
    }

    public double getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(double averageTime) {
        this.averageTime = averageTime;
    }
}
