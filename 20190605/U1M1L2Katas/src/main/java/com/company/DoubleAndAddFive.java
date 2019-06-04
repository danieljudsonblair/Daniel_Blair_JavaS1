package com.company;

import java.util.Scanner;

public class DoubleAndAddFive {

    public static void main(String[] args) {
        String anotherNum = "Enter another number";
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num1 = Integer.parseInt(myScanner.nextLine());
        System.out.println(anotherNum);
        int num2 = num1 * 2;
        int num3 = num2 + 5;
        System.out.println("Your result is: " + num3);
    }
}
