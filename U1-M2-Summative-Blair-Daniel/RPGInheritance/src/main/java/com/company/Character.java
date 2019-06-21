package com.company;

public class Character {
    protected int health = 100;
    protected int strength;
    protected int stamina;
    protected int speed;
    protected int attackPower;
    protected String name;
    protected int shieldStrength = 1;


    Character(String name) {
        System.out.println("Constructing a character");
        this.name = name;
    }

    // speed decreases as a function of health
    // stamina decreases as a function of strength
    public void run() {
        System.out.println("I can run at speed " + this.speed / (100 / this.health) + ".");
        decreaseStamina((100 - this.strength) / 10);
    }
    // victim health decreases directly according to attacker's attackPower
    // attacker stamina decreases as a function of strength

    public void attack(Character victim) {
        System.out.println("I am attacking you, " + victim.name + " with power " + this.attackPower + ".");
        victim.decreaseHealth(this);
        this.decreaseStamina((100 - this.strength) / 5);
    }

     public void heal(int healthPointsIn){
        System.out.println("My health just went up by " + healthPointsIn + " points!");
        if (100 - this.health >= healthPointsIn) {
            this.health += healthPointsIn;
            System.out.println("My health is now " + this.health + "!");
        } else {
            System.out.println("My health is now 100!");
            this.health = 100;
        }
    }

    public void decreaseHealth(Character attacker) {
        this.health = this.health - attacker.attackPower / (1 + this.shieldStrength / 33);
        System.out.println("I've been attacked by " + attacker.name +  ".  My health is now " + this.health + "!");
    }

    public void increaseStamina(int staminaIncrease) {
        System.out.println("My stamina just went up by " + staminaIncrease + " points!");
        if (100 - this.stamina >= staminaIncrease) {
            this.stamina += staminaIncrease;
            System.out.println("My stamina is now " + this.stamina + ".");
        } else {
            System.out.println("My stamina is now 100!");
            this.stamina = 100;
        }
    }

    public void decreaseStamina(int staminaDecrease) {
        this.stamina -= staminaDecrease;
        System.out.println("My stamina just went down by " + staminaDecrease + " points!  My stamina is now " + this.stamina + ".");
    }
}
