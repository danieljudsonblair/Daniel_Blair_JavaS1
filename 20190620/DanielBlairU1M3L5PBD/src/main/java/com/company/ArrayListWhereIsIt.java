package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ArrayListWhereIsIt {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Random rand = new Random();
        List<Integer> myRandomArrayList = new ArrayList<>();

        while (myRandomArrayList.size() < 10) {
            myRandomArrayList.add(rand.nextInt(49) + 1);
        }

        System.out.println("ArrayList: " + myRandomArrayList);
        System.out.print("Value to find: ");
        int num = Integer.parseInt(myScanner.next());
        System.out.println();
        boolean isThere = false;
        for (int i = 0; i < myRandomArrayList.size(); i++) {
            if (num == myRandomArrayList.get(i)) {
                System.out.println(num + " is in slot " + i + ".");
                isThere = true;
            }
        }
        if (!isThere) {
            System.out.println(num + " is not in the ArrayList.");
        }
    }
}
