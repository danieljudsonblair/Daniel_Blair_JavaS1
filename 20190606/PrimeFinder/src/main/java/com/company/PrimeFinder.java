package com.company;

import java.util.Scanner;

public class PrimeFinder {
    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        System.out.println("Please Enter a number");
        int num = myscanner.nextInt();
        byte counter = 0;
        for (short i = 2; i <=num; i++) {
            for (short j = 1;  j<= i; j++) {
                if (i % j == 0) {
                    counter++;
                }
            }
            if (counter == 2) {
                System.out.println(i + "\r");
            }
            counter = 0;
        }
    }
}