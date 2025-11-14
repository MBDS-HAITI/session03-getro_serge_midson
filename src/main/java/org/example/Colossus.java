package org.example;

public class Colossus extends Character implements Attacker{

    public Colossus(String name) {
        super(name, "Colossus", 160, new Weapon("Hammer", 18));
    }


    @Override
    public void attack(Character target) {
        System.out.println();
    }


    @Override
    public void describe() {
        System.out.println(name + " - Colossus | HP: " + currentHp + "/" + maxHp + " | Weapon: " + weapon + " | Very resistant");
    }
}


