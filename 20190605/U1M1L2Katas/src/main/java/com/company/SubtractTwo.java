package com.company;

import java.util.Scanner;

public class SubtractTwo {

    public static void main(String[] args) {
        String anotherNum = "Enter another number";
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num1 = Integer.parseInt(myScanner.nextLine());
        System.out.println(anotherNum);
        int num2 = Integer.parseInt(myScanner.nextLine());
        int sum = num1 - num2;
        System.out.println(sum);
    }
}
