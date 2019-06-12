package com.company;

import java.util.Random;

public class DiceDoubles {
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("HERE COMES THE DICE!");
        int roll1 = 0;
        int roll2 = 1;
        while (roll1 != roll2) {
            roll1 = rand.nextInt((6 - 1) + 1) + 1;
            roll2 = rand.nextInt((6 - 1) + 1) + 1;
            System.out.println("");
            System.out.println("Roll #1: " + roll1);
            System.out.println("Roll #2: " + roll2);
            System.out.println("The total is " + (roll1 + roll2) + "!");
        }
    }
}
