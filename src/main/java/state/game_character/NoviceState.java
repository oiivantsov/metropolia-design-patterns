package state.game_character;

// Concrete State
public class NoviceState extends State {

    public NoviceState(GameCharacter character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println("Training... Gained 10 XP.");
        getCharacter().addExperience(10);

        if (getCharacter().getExperience() >= 30) {
            System.out.println("Level up to Intermediate!");
        }
    }

    @Override
    public void meditate() {
        System.out.println("Meditation not available at Novice level.");
    }

    @Override
    public void fight() {
        System.out.println("Fighting not available at Novice level.");
    }
}
