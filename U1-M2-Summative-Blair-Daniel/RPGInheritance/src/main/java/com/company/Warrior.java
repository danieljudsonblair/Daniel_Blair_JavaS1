package com.company;

public class Warrior extends Character {

    Warrior(String name) {
        super(name);
        this.strength = 75;
        this.stamina = 100;
        this.speed = 50;
        this.attackPower = 10;
        this.shieldStrength = 100;
        getName();
    }

    public void getName() {
        System.out.println("My name is " + name + " and I am a Warrior.");
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
            decreaseShieldStrength(attacker);
            super.decreaseHealth(attacker);
    }

    protected void increaseStamina(int staminaIncrease) {
        super.increaseStamina(staminaIncrease);
    }

    protected void decreaseStamina(int staminaDecrease) {
        super.decreaseStamina(staminaDecrease);
    }

    protected void decreaseShieldStrength(Character attacker) {
        shieldStrength -= attacker.attackPower;
        System.out.println("My shield strength has gone down by " + (attacker.attackPower) + ".  My shield strength is now " + shieldStrength + ".");
    }
}
