package com.company;


import java.util.Random;
import java.util.Scanner;


public class HiLo {
    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        Random rand = new Random();

        byte max = 100;      // max <= 127 with type byte
        byte min = 1;        // also <= 127 with type byte
        int random = rand.nextInt((max - min) + 1) + min;

        System.out.println("Welcome to Hi-Low!");
        System.out.println("Please Enter your name:");
        String name = myscanner.nextLine();

        System.out.println("OK, " + name + ", here are the rules:");
        System.out.println("Guess a number between 1-100");
        int number = myscanner.nextInt();

        boolean exactNumber = false;
        byte guesses = 0;
        while (!exactNumber) {
            if (number < random) {
                System.out.println("Too Low!");
                System.out.println("Guess again!");
                number = myscanner.nextInt();
                guesses++;
            } else if (number > random) {
                System.out.println("Too high!");
                System.out.println("Guess again!");
                number = myscanner.nextInt();
                guesses++;
            } else {
                System.out.println("Congratulations, " + name + "! You win!");
                exactNumber = true;
                guesses++;
            }
        }
        System.out.println("It took you " + guesses + " guesses to find my number!");
    }
}