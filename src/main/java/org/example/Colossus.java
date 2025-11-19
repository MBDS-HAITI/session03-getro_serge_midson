package org.example;

public class Colossus extends Character implements Attacker{
    public Colossus(String name) {
        super(name, 200, new Weapon(15));
    }

    @Override
    public String getType() {
        return "Colossus";
    }
}


