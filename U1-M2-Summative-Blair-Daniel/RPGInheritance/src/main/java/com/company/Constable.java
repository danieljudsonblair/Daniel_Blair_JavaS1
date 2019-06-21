package com.company;

public class Constable extends Character {
    protected String jurisdiction;
    protected int runctr = 0;


    public Constable(String name) {
        super(name);
        jurisdiction = "this jurisdiction";
        this.strength = 60;
        this.stamina = 60;
        this.speed = 20;
        this.attackPower = 5;
        getName();
    }

    public void getName() {
        System.out.println("My name is " + name + " and I am a Constable of " + jurisdiction + ".");
    }

    protected void run() {
        super.run();
        runctr++;
        if (runctr % 10 > 5) {
            jurisdiction = "this jurisdiction";
        } else {
            jurisdiction = "that jurisdiction";
        }
    }

    protected void attack(Character victim) {
        super.attack(victim);
    }

    protected void heal(int healthPoints) {
        super.heal(healthPoints);
    }

    protected void decreaseHealth(Character attacker) {
        super.decreaseHealth(attacker);
    }

    protected void increaseStamina(int staminaIncrease) {
        super.increaseStamina(staminaIncrease);
    }

    protected void decreaseStamina(int staminaDecrease) {
        super.decreaseStamina(staminaDecrease);
    }

    protected void arrest() {
        if (jurisdiction.equals("this jurisdiction")) {
            System.out.println("You have the right to remain silent!");
            increaseStamina(5);
            heal(10);
        } else {
            System.out.println("I can't arrest you outside my jurisdiction!");
        }
    }

    public static void main(String[] args) {
        Constable constable = new Constable("Constable");
        Farmer farmer = new Farmer("Farmer");
        Warrior warrior = new Warrior("Warrior");
        System.out.println(constable.health);
        farmer.attack(constable);
        farmer.attack(warrior);
    }
}
