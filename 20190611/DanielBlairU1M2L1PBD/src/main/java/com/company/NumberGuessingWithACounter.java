package com.company;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingWithACounter {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner myScanner = new Scanner(System.in);

        System.out.println("I have chosen a number between 1 and 10.  Try to guess it.");
        System.out.print("Your guess: ");
        int guess = myScanner.nextInt();

        int random = rand.nextInt((10 - 1) + 1) + 1;
        int ctr = 1;

        while (random != guess) {
            System.out.println("That is incorrect. Guess again.");
            System.out.print("Your guess: ");
            guess = myScanner.nextInt();
            ctr++;
        }
        System.out.println("That's right! You're a good guesser.");
        System.out.println("It only took you " + ctr + " tries.");
    }
}
