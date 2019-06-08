package com.company;

import java.util.Scanner;

/**
 * For testing convenience:
 * Code has been written to repeat 13 times, allowing to test values 0-13
 * to confirm test specs before exiting
 */

public class MonthConverterSwitch {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int ctr = 0;

        while (ctr < 14) {
            System.out.println("Enter an integer 1-12");

            int num = Integer.parseInt(myScanner.nextLine());

            switch (num) {
                case 1:
                    System.out.println("January");
                    ctr++;
                    break;
                case 2:
                    System.out.println("February");
                    ctr++;
                    break;
                case 3:
                    System.out.println("March");
                    ctr++;
                    break;
                case 4:
                    System.out.println("April");
                    ctr++;
                    break;
                case 5:
                    System.out.println("May");
                    ctr++;
                    break;
                case 6:
                    System.out.println("June");
                    ctr++;
                    break;
                case 7:
                    System.out.println("July");
                    ctr++;
                    break;
                case 8:
                    System.out.println("August");
                    ctr++;
                    break;
                case 9:
                    System.out.println("September");
                    ctr++;
                    break;
                case 10:
                    System.out.println("October");
                    ctr++;
                    break;
                case 11:
                    System.out.println("November");
                    ctr++;
                    break;
                case 12:
                    System.out.println("December");
                    ctr++;
                    break;
                default:
                    System.out.println("You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.");
                    ctr++;
            }
        }
    }
}
