package org.example;



class Warrior extends Character implements Attacker{

    public Warrior(String name) {
        super(name, 120, new Weapon(20));
    }

    @Override
    public String getType() {
        return "Warrior";
    }
}
