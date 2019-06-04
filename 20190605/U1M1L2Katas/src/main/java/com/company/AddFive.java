package com.company;

import java.util.Scanner;

public class AddFive {

    public static void main(String[] args) {
        String anotherNum = "Enter another number";
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num1 = Integer.parseInt(myScanner.nextLine());
        System.out.println(anotherNum);
        int num2 = Integer.parseInt(myScanner.nextLine());
        System.out.println(anotherNum);
        int num3 = Integer.parseInt(myScanner.nextLine());
        System.out.println(anotherNum);
        int num4 = Integer.parseInt(myScanner.nextLine());
        System.out.println(anotherNum);
        int num5 = Integer.parseInt(myScanner.nextLine());
        int sum = num1 + num2 + num3 + num4 + num5;
        System.out.println("Your total is: " + sum);
    }
}
