package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    private List<Character> team = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void createTeam(Scanner scanner) {
        List<String> usedTypes = new ArrayList<>();

        while (team.size() < 3) {
            System.out.println("\nChoose character type:");
            System.out.println("1) Warrior");
            System.out.println("2) Magus");
            System.out.println("3) Colossus");
            System.out.println("4) Dwarf");

            int choice = scanner.nextInt();
            scanner.nextLine();

            String typeName = switch (choice) {
                case 1 -> "Warrior";
                case 2 -> "Magus";
                case 3 -> "Colossus";
                case 4 -> "Dwarf";
                default -> null;
            };

            if (typeName == null || usedTypes.contains(typeName)) {
                System.out.println("Invalid or already chosen type!");
                continue;
            }

            System.out.print("Enter unique character name: ");
            String name = scanner.nextLine();

            Character c = switch (typeName) {
                case "Warrior" -> new Warrior(name);
                case "Magus" -> new Magus(name);
                case "Colossus" -> new Colossus(name);
                case "Dwarf" -> new Dwarf(name);
                default -> null;
            };

            team.add(c);
            usedTypes.add(typeName);

            System.out.println(c.getName() + " added!");
        }
    }

    public Character chooseCharacter(Scanner scanner) {
        System.out.println("Choose character:");
        for (int i = 0; i < team.size(); i++) {
            Character c = team.get(i);
            System.out.println((i + 1) + ") " + c);
        }
        int choice = scanner.nextInt() - 1;
        scanner.nextLine();
        return team.get(choice);
    }

    public boolean isAlive() {
        return team.stream().anyMatch(Character::isAlive);
    }

    public void showTeam() {
        System.out.println("\n" + name + "'s Team:");
        team.forEach(System.out::println);
    }
}
