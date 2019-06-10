package com.company;

import java.util.Random;

public class Dice {
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("HERE COMES THE DICE!");
        int roll1 = rand.nextInt((6 - 1) + 1) + 1;
        int roll2 = rand.nextInt((6 - 1) + 1) + 1;
        System.out.println("");
        System.out.println("Roll #1: " + roll1);
        System.out.println("Roll #2: " + roll2);
        System.out.println("The total is " + (roll1 + roll2) + "!");
    }
}
