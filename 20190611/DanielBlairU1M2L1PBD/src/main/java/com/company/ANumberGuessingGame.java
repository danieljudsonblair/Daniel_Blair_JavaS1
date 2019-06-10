package com.company;

import java.util.Random;
import java.util.Scanner;

public class ANumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner myScanner = new Scanner(System.in);
        int max = 10;
        int min = 1;
        int random = (rand.nextInt((max - min) + 1) + min);
        System.out.println("I'm thinking of a number from 1 to 10");
        System.out.println("Your guess: ");
        int guess = myScanner.nextInt();

        if (guess != random) {
            System.out.println("Sorry, but I was really thinking of " + random + ".");
        } else {
                System.out.println("That's right! My secret number was " + random);
        }
    }
}
