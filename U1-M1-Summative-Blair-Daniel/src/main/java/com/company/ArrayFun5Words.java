package com.company;

import java.util.Scanner;

public class ArrayFun5Words {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int ctr = 0;
        String [] arr = new String [5];

        while (ctr < 5) {
            System.out.println("Enter a word:");
            arr[ctr] = myScanner.nextLine();
            ctr++;
        }
        for (String x : arr) {
            System.out.println(x);
        }
    }
}
