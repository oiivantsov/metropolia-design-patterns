package state.game_character;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();
        GameCharacter character = new GameCharacter(name);

        while (!(character.getCurrentState() instanceof MasterState)) {
            System.out.println(character);
            System.out.println("Choose an action: 1. Train 2. Meditate 3. Fight");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> character.train();
                case 2 -> character.meditate();
                case 3 -> character.fight();
                default -> System.out.println("Invalid choice. Try again.");
            }
        }

        System.out.println("Congratulations! You've reached Master level.");
        scanner.close();
    }
}
