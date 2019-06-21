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

    public void harvest() {
        System.out.println("I just harvested some crop!");
        increaseStamina(5);
    }

    public void plow() {
        System.out.println("I just plowed the field!");
        heal(10);
    }
}
