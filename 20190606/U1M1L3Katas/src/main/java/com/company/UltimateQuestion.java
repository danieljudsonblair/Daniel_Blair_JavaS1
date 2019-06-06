package com.company;

import java.util.Scanner;

public class UltimateQuestion {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please enter a number between 1 and 100");
        int num = Integer.parseInt(myScanner.nextLine());

        while (num != 42) {
            System.out.println("Please Enter a number between 1 to 100");
            num = Integer.parseInt(myScanner.nextLine());
        }
        System.out.println("That's the number I was looking for! 42 is definitely the answer!");
    }
}
