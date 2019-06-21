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

    public void decreaseHealth(Character attacker) {
            decreaseShieldStrength(attacker);
            super.decreaseHealth(attacker);
    }

    public void decreaseShieldStrength(Character attacker) {
        shieldStrength -= attacker.attackPower;
        System.out.println("My shield strength has gone down by " + (attacker.attackPower) + ".  My shield strength is now " + shieldStrength + ".");
    }
}
