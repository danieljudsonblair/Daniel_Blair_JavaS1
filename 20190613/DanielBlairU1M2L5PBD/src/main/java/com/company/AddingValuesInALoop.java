package com.company;

import java.util.Scanner;

public class AddingValuesInALoop {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("I will add up the numbers you give me.");
        System.out.print("Number: ");
        int num = myScanner.nextInt();
        int total = num;

        while (num != 0) {
            System.out.println("The total so far is " + total);
            System.out.print("Number: ");
            num = myScanner.nextInt();
            total += num;
        }
        System.out.println("");
        System.out.println("The total is " + total);
    }
}
