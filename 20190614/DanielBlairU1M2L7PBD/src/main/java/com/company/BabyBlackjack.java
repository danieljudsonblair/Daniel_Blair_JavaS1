package com.company;

import java.util.Random;

public class BabyBlackjack {
    public static void main(String[] args) {
        Random rand = new Random();

        int rand1 = rand.nextInt((9) + 1) + 1;
        int rand2 = rand.nextInt((9) + 1) + 1;

        int rand3 = rand.nextInt((9) + 1) + 1;
        int rand4 = rand.nextInt((9) + 1) + 1;

        System.out.println("Baby Blackjack!");
        System.out.println("");
        System.out.println("You drew " + rand1 + " and " + rand2 + ".");
        System.out.println("Your total is " + (rand1 + rand2) + ".");
        System.out.println("");
        System.out.println("The dealer has " + rand3 + " and " + rand4 + ".");
        System.out.println("Dealer's total is " + (rand3 + rand4) + ".");
        System.out.println("");

        if (rand1+rand2 > rand3+rand4) {
            System.out.println("YOU WIN!");
        } else if (rand1+rand2 < rand3+rand4) {
            System.out.println("DEALER WINS!");
        } else {
            System.out.println("IT'S A TIE!!");
        }
    }
}
