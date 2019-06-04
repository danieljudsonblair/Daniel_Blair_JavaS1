package com.company;

import java.util.Scanner;

public class MultiplyThree {

    public static void main(String[] args) {
        String anotherNum = "Enter another number";
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        float num1 = Integer.parseInt(myScanner.nextLine());
        System.out.println(anotherNum);
        float num2 = Integer.parseInt(myScanner.nextLine());
        System.out.println(anotherNum);
        float num3 = Integer.parseInt(myScanner.nextLine());
        float sum = (num1 * num2 * num3);
        System.out.printf("%.2f", sum);
    }
}