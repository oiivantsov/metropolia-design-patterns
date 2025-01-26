package state.game_character;

// Concrete State
public class IntermediateState extends State {

    public IntermediateState(GameCharacter character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println("Training... Gained 15 XP.");
        getCharacter().addExperience(15);

        if (getCharacter().getExperience() >= 90) {
            System.out.println("Level up to Expert!");
        }
    }

    @Override
    public void meditate() {
        System.out.println("Meditating... Gained 20 HP.");
        getCharacter().addHealth(20);
    }

    @Override
    public void fight() {
        System.out.println("Fighting not available at Intermediate level.");
    }
}