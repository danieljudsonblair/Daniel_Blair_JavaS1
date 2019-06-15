package com.company;

import java.util.Scanner;

public class Nim {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int a = 3;
        int b = 4;
        int c = 5;
        boolean empty = false;
        int howMany = 0;
        String out;
        String player1;
        String player2;
        int turn = 0;
        String player;

        System.out.print("Player 1, enter your name: ");
        player1 = myScanner.next();
        System.out.print("Player 2, enter your name: ");
        player2 = myScanner.next();
        System.out.println();

        while (!empty) {
            out = "A:: " + a + "    B:: " + b + "    C:: " + c;
            System.out.println(out);
            System.out.println();
            if (turn % 2 == 0) {
                player = player1;
            } else {
                player = player2;
            }
            System.out.print(player + ", choose a pile: ");
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
            turn++;
            if (a <= 0 && b <= 0 && c <= 0) {
                System.out.println("A:: " + a + "    B:: " + b + "    C:: " + c);
                empty = true;
                if (player == player1) {
                    player = player2;
                } else if (player == player2) {
                    player = player1;
                }
                System.out.println();
                System.out.println(player + ", there are no counters left, so you WIN!");
            }
        }


    }
}
