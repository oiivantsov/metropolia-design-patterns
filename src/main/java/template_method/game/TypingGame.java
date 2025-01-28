package template_method.game;

import java.util.Scanner;

public class TypingGame extends Game {

    private static final String[] WORDS = {"ruoka", "luokka", "kastike", "tietokanta", "ohjelmointi", "suunnitelmamalli"};
    private Player[] players;
    private boolean gameEnded;

    @Override
    public void initializeGame(int numberOfPlayers) {
        System.out.println("Welcome to the Typing Speed Game!");
        System.out.println("Type all the given words as fast as you can. The player with the lowest average time wins.");
        players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            players[i] = new Player("Player " + (i + 1));
        }
        gameEnded = false;
        System.out.println("Game initialized for " + numberOfPlayers + " players.");
    }

    @Override
    public boolean endOfGame() {
        return gameEnded;
    }

    @Override
    public void playSingleTurn(int playerIndex) {
        Scanner scanner = new Scanner(System.in);
        Player player = players[playerIndex];
        double totalTypingTime = 0;

        // player readiness
        System.out.println(player.getName() + ", type 'y' when you're ready.");
        while (!scanner.nextLine().equalsIgnoreCase("y")) {
            System.out.println("Type 'y' to start your turn!");
        }

        // countdown
        System.out.println("Get ready...");
        for (int i = 3; i > 0; i--) {
            System.out.print(i + "...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("GO!");

        for (String word : WORDS) {
            System.out.println("Word to type: " + word);
            long startTime = System.nanoTime();
            String userInput = scanner.nextLine();
            long elapsedTime = System.nanoTime() - startTime;

            if (!userInput.equals(word)) {
                System.out.println("Wrong word! You must type the exact word: " + word);
                continue; // retry the same word
            }

            System.out.println("Correct! Time taken: " + (elapsedTime / 1_000_000.0) + " ms");
            totalTypingTime += elapsedTime / 1_000_000.0; // convert to milliseconds
        }

        player.setAverageTime(totalTypingTime / WORDS.length);
        System.out.println(player.getName() + " finished with an average time of " + player.getAverageTime() + " ms per word.");

        // if all players are done
        if (allPlayersFinished()) {
            gameEnded = true;
        }
    }

    private boolean allPlayersFinished() {
        for (Player player : players) {
            if (player.getAverageTime() == 0) {
                return false; // at least one player hasn't finished
            }
        }
        return true;
    }

    @Override
    public void displayWinner() {
        System.out.println("Game over! Calculating the winner...");
        Player winner = null;
        double lowestAverageTime = Double.MAX_VALUE;

        for (Player player : players) {
            System.out.println(player.getName() + " - Average time: " + player.getAverageTime() + " ms");
            if (player.getAverageTime() < lowestAverageTime) {
                lowestAverageTime = player.getAverageTime();
                winner = player;
            }
        }

        if (winner != null) {
            System.out.println("The winner is " + winner.getName() + " with an average time of " + lowestAverageTime + " ms per word!");
        }
    }
}