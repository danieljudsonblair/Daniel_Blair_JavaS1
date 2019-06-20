package com.company;

public class Farmer extends Character {

    Farmer(String name){
        super(name);
        this.strength = 75;
        this.stamina = 75;
        this.speed = 10;
        this.attackPower = 1;
        getName();
    }

    public void getName() {
        System.out.println("My name is " + name + " and I am a Farmer.");
    }

    protected void run() {
        super.run();
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

    protected void decreaseStamina(int myStaminaDecrease) {
        super.decreaseStamina(myStaminaDecrease);
    }

    protected void harvest() {
        System.out.println("I just harvested some crop!");
        increaseStamina(5);
    }

    protected void plow() {
        System.out.println("I just plowed the field!");
        heal(10);
    }
}
