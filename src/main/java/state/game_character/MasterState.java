package state.game_character;

// Concrete State
public class MasterState extends State {

    public MasterState(GameCharacter character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println("You are a Master! Training no longer needed.");
    }

    @Override
    public void meditate() {
        System.out.println("You are a Master! Meditation no longer needed.");
    }

    @Override
    public void fight() {
        System.out.println("You are a Master! Fighting no longer needed.");
    }
}