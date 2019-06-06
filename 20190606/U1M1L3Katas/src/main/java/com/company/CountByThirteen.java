package com.company;

import java.util.Scanner;

public class CountByThirteen {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please Enter a number");
        int num = Integer.parseInt(myScanner.nextLine());

        for (int i = 0; i <= num; i = i + 13) {
            System.out.println(i + "\r");
        }
    }
}