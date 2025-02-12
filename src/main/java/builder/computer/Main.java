package builder.computer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose computer type: 1. Gaming 2. Office");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter accessories (comma-separated, or leave empty):");
        String accessoriesInput = scanner.nextLine();
        List<Accessory> accessories = new ArrayList<>();
        if (!accessoriesInput.isEmpty()) {
            for (String acc : accessoriesInput.split(", ")) {
                accessories.add(new Accessory(acc));
            }
        }

        ComputerBuilder builder;
        if (choice == 1) {
            builder = new GamingComputerBuilder();
        } else {
            builder = new OfficeComputerBuilder();
        }

        ComputerDirector director = new ComputerDirector(builder);
        Computer computer = director.constructComputer(accessories);
        System.out.println(computer);
    }
}