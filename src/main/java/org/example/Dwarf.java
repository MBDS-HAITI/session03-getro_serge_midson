package org.example;

public class Dwarf extends Character implements Attacker{

    public Dwarf(String name) {
        super(name, "Dwarf", 80, new Weapon("Axe", 30));
    }


    @Override
    public void attack(Character target) {
        System.out.println();
    }


    @Override
    public void describe() {
        System.out.println(name + " - Dwarf | HP: " + currentHp + "/" + maxHp + " | Weapon: " + weapon + " | Fragile but deadly");
    }
}
