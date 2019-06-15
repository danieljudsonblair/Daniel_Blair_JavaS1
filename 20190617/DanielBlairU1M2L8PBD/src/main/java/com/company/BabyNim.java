package com.company;

import java.util.Scanner;

public class BabyNim {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int a = 3;
        int b = 3;
        int c = 3;
        boolean empty = false;
        int howMany;

        while (!empty) {
            System.out.println("A:: " + a + "    B:: " + b + "    C:: " + c);
            System.out.println();
            System.out.print("Choose a pile: ");
            String choice = myScanner.next().toUpperCase();
            System.out.print("How many to remove from pile " + choice + ": ");
            howMany = myScanner.nextInt();
            System.out.println();
            if (choice.equals("A")) {
                a = a - howMany;
            } else if (choice.equals("B")) {
                b = b - howMany;
            } else if (choice.equals("C")) {
                c = c - howMany;
            }
            if (a <= 0 && b <= 0 && c <= 0) {
                System.out.println("A:: " + a + "    B:: " + b + "    C:: " + c);
                empty = true;
            }
        }
        System.out.println();
        System.out.println("All piles are empty. Good job!");
    }
}
