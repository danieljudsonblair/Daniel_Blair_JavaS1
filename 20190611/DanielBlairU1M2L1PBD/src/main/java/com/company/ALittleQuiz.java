package com.company;

import java.util.Scanner;

public class ALittleQuiz {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Are you ready for a quiz? ");
        String ready = myScanner.next();
        System.out.println("Okay, here it comes!");
        System.out.println("                    ");
        System.out.println("Q1) What is the capital of North Carolina?");
        System.out.println("        1) Charlotte");
        System.out.println("        2) Raleigh");
        System.out.println("        3) Asheville");
        System.out.println("                    ");
        System.out.print("> ");
        int ans = myScanner.nextInt();
        System.out.println("                    ");

        int score = 0;

        if (ans != 2) {
            System.out.println("Sorry, the correct answer is Raleigh.");
        } else {
            System.out.println("That's right!");
            score++;
        }
        System.out.println("                                          ");
        System.out.println("Q2) Can you store the value \" dog \" in a variable of type int?");
        System.out.println("        1) yes");
        System.out.println("        2) no");
        System.out.println("                    ");
        System.out.print("> ");
        ans = myScanner.nextInt();
        System.out.println("                    ");

        if (ans != 2) {
            System.out.println("Sorry, \"dog\" is a string.  ints can only store non-decimal numbers.");
        } else {
            System.out.println("That is correct!");
            score++;
        }
        System.out.println("                                          ");
        System.out.println("Q3) What is the result of 5+12/3?");
        System.out.println("        1) 17/3");
        System.out.println("        2) 4");
        System.out.println("        3) 9");
        System.out.println("                    ");
        System.out.print("> ");
        ans = myScanner.nextInt();
        System.out.println("                    ");

        if (ans != 3) {
            System.out.println("Sorry, the correct answer is 9");
        } else {
            System.out.println("That's right!");
            score++;
        }
        System.out.println("");
        System.out.println("");
        System.out.println("Overall, you got " + score + " out of 3 correct.");
        System.out.println("Thanks for playing!");
    }
}
