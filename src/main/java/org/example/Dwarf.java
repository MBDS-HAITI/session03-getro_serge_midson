package org.example;

public class Dwarf extends Character implements Attacker{
    public Dwarf(String name) {
        super(name, 80, new Weapon(35)); // fragile but strong
    }

    @Override
    public String getType() {
        return "Dwarf";
    }
}
