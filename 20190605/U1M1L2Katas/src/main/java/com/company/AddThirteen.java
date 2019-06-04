package com.company;

import java.util.Scanner;

public class AddThirteen {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num1 = Integer.parseInt(myScanner.nextLine());
        int num2 = num1 + 13;
        System.out.println("Your result is: " + num2);
    }
}
