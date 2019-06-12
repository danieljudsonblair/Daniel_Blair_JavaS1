package com.company;

import java.util.Scanner;

public class SafeSquareRoot {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("SQUARE ROOT!");
        System.out.print("Enter a number: ");
        int num = myScanner.nextInt();

        while (num < 0) {
            System.out.println("You can't take the square root of a negative number, silly.");
            System.out.print("Try again: ");
            num = myScanner.nextInt();
        }
        System.out.println("The square root of " + num + " is " + Math.sqrt(num) + ".");
    }
}
