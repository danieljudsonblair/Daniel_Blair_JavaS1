package com.company;

import java.util.Scanner;

public class RangeChecker {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please Enter a number from 16 to 31");
        int num = Integer.parseInt(myScanner.nextLine());

        while (num > 31 || num < 16) {
            System.out.println("Please Enter a number from 16 to 31");
            num = Integer.parseInt(myScanner.nextLine());
        }
        System.out.println(num);


    }
}
