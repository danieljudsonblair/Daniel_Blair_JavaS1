package com.company;

import java.util.Random;
import java.util.Scanner;

public class ThreeCardMonte {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Random rand = new Random();

        int random = rand.nextInt((2 + 1) + 1) + 1;

        System.out.println("You slide up to Fast Eddie's card table and plop down your cash.");
        System.out.println("He glances at you out of the corner of his eye and starts shuffling.");
        System.out.println("He lays down three cards.");
        System.out.println("");
        System.out.println("Which one is the ace?");
        System.out.println("");
        System.out.println("      ##  ##  ##     ");
        System.out.println("      ##  ##  ##     ");
        System.out.println("      1   2   3      ");
        System.out.println("");
        System.out.print("> ");
        int guess = myScanner.nextInt();

        if (guess == 1 && random == 1) {
            System.out.println("");
            System.out.println("You nailed it!  Fast Eddie reluctantly hands over your winnings, scowling.");
            System.out.println("");
            System.out.println("      AA  ##  ##     ");
            System.out.println("      AA  ##  ##     ");
            System.out.println("      1   2   3      ");

        } else if (guess == 2 && random == 2) {
            System.out.println("");
            System.out.println("You nailed it!  Fast Eddie reluctantly hands over your winnings, scowling.");
            System.out.println("");
            System.out.println("      ##  AA  ##     ");
            System.out.println("      ##  AA  ##     ");
            System.out.println("      1   2   3      ");

        } else if (guess == 3 && random == 3) {
            System.out.println("");
            System.out.println("You nailed it!  Fast Eddie reluctantly hands over your winnings, scowling.");
            System.out.println("");
            System.out.println("      ##  ##  AA     ");
            System.out.println("      ##  ##  AA     ");
            System.out.println("      1   2   3      ");

        } else if (random == 1 && guess != 1) {
            System.out.println("");
            System.out.println("Ha! Fast Eddie wins again! The ace was card number 1.");
            System.out.println("");
            System.out.println("      AA  ##  ##     ");
            System.out.println("      AA  ##  ##     ");
            System.out.println("      1   2   3      ");

        } else if (random == 2 && guess != 2) {
            System.out.println("");
            System.out.println("Ha! Fast Eddie wins again! The ace was card number 2.");
            System.out.println("");
            System.out.println("      ##  AA  ##     ");
            System.out.println("      ##  AA  ##     ");
            System.out.println("      1   2   3      ");

        } else if (random == 3 && guess != 3) {
            System.out.println("");
            System.out.println("Ha! Fast Eddie wins again! The ace was card number 3.");
            System.out.println("");
            System.out.println("      ##  ##  AA     ");
            System.out.println("      ##  ##  AA     ");
            System.out.println("      1   2   3      ");

        }
    }
}
