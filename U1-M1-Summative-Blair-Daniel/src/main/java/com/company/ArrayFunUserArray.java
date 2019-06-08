package com.company;

import java.util.Scanner;

public class ArrayFunUserArray {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int ctr = 0;
        int[] arr = new int[5];

        while (ctr < 5) {
            System.out.println("Enter an integer");
            arr[ctr] = Integer.parseInt(myScanner.nextLine());
            ctr++;
        }
        for(int x: arr) {
            System.out.println(x);
        }
    }
}
