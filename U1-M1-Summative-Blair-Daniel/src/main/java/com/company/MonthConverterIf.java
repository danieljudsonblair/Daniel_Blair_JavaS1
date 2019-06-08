package com.company;

import java.util.Scanner;

/**
 * For testing convenience:
 * Code has been written to repeat 13 times, allowing to test values 0-13
 * to confirm test specs before exiting
 */

public class MonthConverterIf {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int ctr = 0;

        while (ctr < 14) {
            System.out.println("Enter an integer 1-12");
            int num = Integer.parseInt(myScanner.nextLine());

            if (num == 1) {
                System.out.println("January");
                ctr++;
            } else if (num == 2) {
                System.out.println("February");
                ctr++;
            } else if (num == 3) {
                System.out.println("March");
                ctr++;
            } else if (num == 4) {
                System.out.println("April");
                ctr++;
            } else if (num == 5) {
                System.out.println("May");
                ctr++;
            } else if (num == 6) {
                System.out.println("June");
                ctr++;
            } else if (num == 7) {
                System.out.println("July");
                ctr++;
            } else if (num == 8) {
                System.out.println("August");
                ctr++;
            } else if (num == 9) {
                System.out.println("September");
                ctr++;
            } else if (num == 10) {
                System.out.println("October");
                ctr++;
            } else if (num == 11) {
                System.out.println("November");
                ctr++;
            } else if (num == 12) {
                System.out.println("December");
                ctr++;
            } else {
                System.out.println("You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.");
                ctr++;
            }
        }
    }
}
