package state.game_character;

// GameCharacter Class - context
public class GameCharacter {
    private String name;
    private int level;
    private int experiencePoints;
    private int healthPoints;
    private State currentState;

    public GameCharacter(String name) {
        this.name = name;
        this.level = 1;
        this.experiencePoints = 0;
        this.healthPoints = 100;
        this.currentState = new NoviceState(this); // Start at Novice
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void addExperience(int points) {
        experiencePoints += points;
        checkLevelUp();
    }

    public void addHealth(int points) {
        healthPoints = Math.min(100, healthPoints + points); // Max health is 100
    }

    public void reduceHealth(int points) {
        healthPoints = Math.max(0, healthPoints - points);
    }

    public void train() {
        currentState.train();
    }

    public void meditate() {
        currentState.meditate();
    }

    public void fight() {
        currentState.fight();
    }

    public int getHealth() {
        return healthPoints;
    }

    public int getExperience() {
        return experiencePoints;
    }

    public void checkLevelUp() {
        if (experiencePoints >= 30 && level == 1) {
            level = 2;
            setState(new IntermediateState(this));
        } else if (experiencePoints >= 90 && level == 2) {
            level = 3;
            setState(new ExpertState(this));
        } else if (experiencePoints >= 200 && level == 3) {
            level = 4;
            setState(new MasterState(this));
        }
    }

    public String getLevel() {
        return switch (level) {
            case 1 -> "Novice";
            case 2 -> "Intermediate";
            case 3 -> "Expert";
            case 4 -> "Master";
            default -> "Unknown";
        };
    }

    @Override
    public String toString() {
        return "Character: " + name + ", Level: " + getLevel() +
                ", XP: " + experiencePoints + ", HP: " + healthPoints;
    }
}