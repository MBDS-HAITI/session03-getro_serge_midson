package org.example;

public abstract class Character {
    protected String name;
    protected int hp;
    protected Weapon weapon;

    public Character(String name, int hp, Weapon weapon) {
        this.name = name;
        this.hp = hp;
        this.weapon = weapon;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void receiveDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
        System.out.println(name + " takes " + damage + " damage (HP: " + hp + ")");
    }

    public void heal(int amount) {
        hp += amount;
        System.out.println(name + " is healed by " + amount + " (HP: " + hp + ")");
    }

    public void attack(Character target) {
        int damage = weapon.getPower();
        System.out.println(name + " attacks " + target.name + " for " + damage);
        target.receiveDamage(damage);
    }

    public abstract String getType();

    public String getName() { return name; }

    @Override
    public String toString() {
        return "[" + getType() + "] " + name + " - HP: " + hp + " - Weapon: " + weapon.getPower();
    }
}
