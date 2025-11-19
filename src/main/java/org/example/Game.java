package org.example;
import java.util.Scanner;



public class Game {
    private Player player1;
    private Player player2;

    private Scanner scanner = new Scanner(System.in);
    private int turnCount = 0;

    public void start() {
        System.out.println("=== BATTLE ARENA ===");

        System.out.print("Enter name for Player 1: ");
        player1 = new Player(scanner.nextLine());

        System.out.print("Enter name for Player 2: ");
        player2 = new Player(scanner.nextLine());

        System.out.println("\n--- Player 1, create your team ---");
        player1.createTeam(scanner);

        System.out.println("\n--- Player 2, create your team ---");
        player2.createTeam(scanner);

        fight();
    }

    private void fight() {
        Player active = player1;
        Player opponent = player2;

        while (player1.isAlive() && player2.isAlive()) {
            turnCount++;
            System.out.println("\n=== TURN " + turnCount + " ===");
            System.out.println("Active player: " + active.getName());

            active.showTeam();
            opponent.showTeam();

            Character actor = active.chooseCharacter(scanner);
            System.out.println("Selected: " + actor.getName());

            System.out.println("Choose action:");
            System.out.println("1) Attack");
            System.out.println("2) Heal");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Character targetEnemy = opponent.chooseCharacter(scanner);
                    actor.attack(targetEnemy);
                    break;

                case 2:
                    if (actor instanceof Healer) {
                        Character targetAlly = active.chooseCharacter(scanner);
                        ((Healer) actor).heal(targetAlly);
                    } else {
                        System.out.println(actor.getName() + " cannot heal!");
                    }
                    break;
            }

            // Swap active/opponent
            Player temp = active;
            active = opponent;
            opponent = temp;
        }

        endGame();
    }

    private void endGame() {
        Player winner = player1.isAlive() ? player1 : player2;

        System.out.println("\n=== GAME OVER ===");
        System.out.println("Winner: " + winner.getName());
        System.out.println("Total turns: " + turnCount);

        System.out.println("\n--- Final Teams Status ---");
        player1.showTeam();
        player2.showTeam();
    }
}
