package org.example;



class Warrior extends Character implements Attacker{
    public Warrior(String name){
        super(name,"Warrior", 100, new Weapon("Sword", 20));
    }

    @Override
    public void attack(Character target) {
        System.out.println("tt");
        target.receiveDamage(weapon.getPower());
    }

    @Override
    public void describe() {
        System.out.println();
    }
}
