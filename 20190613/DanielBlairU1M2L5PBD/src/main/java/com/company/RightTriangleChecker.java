package com.company;

import java.util.Scanner;

public class RightTriangleChecker {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter three integers: ");
        System.out.print("Side 1: ");
        int sd1 = myScanner.nextInt();
        System.out.print("Side 2: ");
        int sd2 = myScanner.nextInt();

        while (sd2 < sd1) {
            System.out.println(sd2 + " is smaller than " + sd1 + ". Try again.");
            System.out.print("Side 2: ");
            sd2 = myScanner.nextInt();
        }
        System.out.print("Side 3: ");
        int sd3 = myScanner.nextInt();

        while (sd3 < sd2) {
            System.out.println(sd3 + " is smaller than " + sd2 + ". Try again.");
            System.out.print("Side 3: ");
            sd3 = myScanner.nextInt();
        }
        System.out.println("");
        System.out.println("Your three sides are " + sd1 + " " + sd2 + " " + sd3);
        if (sd1*sd1 + sd2*sd2 == sd3*sd3) {
            System.out.println("These sides *do* make a right triangle. Yippy-skippy!");
        } else {
            System.out.println("NO! These sides do not make a right triangle!");
        }
    }
}
