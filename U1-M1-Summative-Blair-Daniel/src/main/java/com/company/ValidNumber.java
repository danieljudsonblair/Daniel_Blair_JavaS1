package com.company;

import java.util.Scanner;

public class ValidNumber {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        boolean isValid = false;

        System.out.println("Enter a number 1-10");

        while (!isValid) {

            float num = Float.parseFloat(myScanner.nextLine());
            if (num > 10 || num < 1) {
                System.out.println("You must enter a number between 1 and 10, please try again");
            } else {
                System.out.println(num);
                isValid = true;
            }
        }
    }
}
