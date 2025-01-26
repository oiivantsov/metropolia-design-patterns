package state.game_character;

import java.sql.SQLOutput;

// Concrete State
public class ExpertState extends State {

    public ExpertState(GameCharacter character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println("Training... Gained 1 XP.");
        getCharacter().addExperience(1);
    }

    @Override
    public void meditate() {
        System.out.println("Meditating... Gained 10 HP.");
        getCharacter().addHealth(10);
    }

    @Override
    public void fight() {
        if (getCharacter().getHealth() < 26) {
            System.out.println("Your health is too low to fight! Meditate to recover health.");
            return;
        }
        System.out.println("Fighting... Gained 30 XP, lost 25 HP.");
        getCharacter().addExperience(30);
        getCharacter().reduceHealth(25);
    }
}
