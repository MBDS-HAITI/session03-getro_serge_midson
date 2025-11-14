package org.example;

public abstract class Character {
    protected final String name;
    protected final String type;
    protected final int maxHp;
    protected int currentHp;
    protected final Weapon weapon;
    protected boolean alive = true;

    public Character(String name, String type, int maxHp, Weapon weapon) {
        this.name = name;
        this.type = type;
        this.maxHp = maxHp;
        this.weapon = weapon;
        this.currentHp = maxHp;
    }


    public String getName() {return name;}
    public String getType() {return type;}
    public int getMaxHp() {return maxHp;}
    public int getCurrentHp() {return currentHp;}
    public Weapon getWeapon() {return weapon;}
    public boolean isAlive() {return alive;}


    public void wakeUp() {
        System.out.println(name + " the " + type + " wakes up.");
    }

    public void eat() {
        System.out.println(name + " eats to regain energy.");
    }

    public void die() {
        alive = false;
        currentHp = 0;
        System.out.println(name + " has died.");
    }

    public void receiveDamage(int dmg) {
        if (!alive) return;
        currentHp -= dmg;
        System.out.println(name + " receives " + dmg + " damage (HP=" + Math.max(currentHp, 0) + "/" + maxHp + ")");
        if (currentHp <= 0) {
            die();
        }
    }

    public void receiveHeal(int amount) {
        currentHp += amount;
        if (currentHp > maxHp) currentHp = maxHp; // cap heal to maxHp
        System.out.println(name + " recovers " + amount + " HP (HP=" + currentHp + "/" + maxHp + ")");
    }

    public abstract void describe();

    static class Warrior extends Character implements Attacker {
        public Warrior(String name) {
            super(name, "Warrior", 100, new Weapon("Sword", 20));
        }


        @Override
        public void attack(Character target) {
            System.out.println();
        }


        @Override
        public void describe() {
            System.out.println(name + " - Warrior | HP: " + currentHp + "/" + maxHp + " | Weapon: " + weapon);
        }

    }
}
