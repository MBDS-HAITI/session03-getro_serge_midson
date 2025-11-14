package org.example;

 public class Magus extends Character{
    public Magus(String name) {
        super(name, "Magus", 120, new Weapon("Staff", 10));
    }

    public void heal(Character ally) {
        int healPower = 25;
        System.out.println("getro is a healer");
    }


    public void attack(Character target) {
        System.out.println(name + " attack ");
    }


    @Override
    public void describe() {
        System.out.println("");
    }
}
