package org.example;

 public class Magus extends Character implements Attacker, Healer {

     public Magus(String name) {
         super(name, 150, new Weapon(10)); // weak attack
     }

     @Override
     public String getType() {
         return "Magus";
     }

     @Override
     public void heal(Character target) {
         System.out.println(name + " heals " + target.getName());

     }
 }
