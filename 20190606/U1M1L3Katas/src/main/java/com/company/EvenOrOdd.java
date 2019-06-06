package com.company;

import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        System.out.println("Please Enter a number");
        int num = Integer.parseInt(myscanner.nextLine());
        if (num % 2 == 0) {
            System.out.println("Your number is even");
        } else {
            System.out.println("Your number is odd");
        }
    }
}
