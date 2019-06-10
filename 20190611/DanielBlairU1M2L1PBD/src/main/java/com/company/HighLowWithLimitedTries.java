package com.company;

import java.util.Random;
import java.util.Scanner;

public class HighLowWithLimitedTries {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner myScanner = new Scanner(System.in);

        int random = rand.nextInt((100 - 1) + 1) + 1;
        System.out.println("I'm thinking of a number between 1-100.  You have 7 guesses");
        System.out.print("First guess: ");
        int guess = myScanner.nextInt();

        int ctr = 2;

        while (ctr <= 7 && guess != random) {
            if (guess < random) {
                System.out.println("Sorry, you are too low.");
                System.out.print("Guess # " + ctr + ": ");
                guess = myScanner.nextInt();
                ctr++;
            } else if (guess > random) {
                System.out.println("Sorry, that guess is too high.");
                System.out.print("Guess # " + ctr + ": ");
                guess = myScanner.nextInt();
                ctr++;
            }
        }
        if (random != guess) {
            System.out.println("Sorry, you didn't guess it in 7 tries.  You lose.");
        } else {
            System.out.println("You guessed it!  What are the odds?!?");
        }
    }
}
