package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LocatingTheLargestValueInArrayList {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> myRandomArrayList = new ArrayList<>();

        while (myRandomArrayList.size() < 10) {
            myRandomArrayList.add(rand.nextInt(99) + 1);
        }

        System.out.println("ArrayList: " + myRandomArrayList);
        System.out.println();
        int max = myRandomArrayList.get(0);
        int index = 0;

        for (int i = 0; i < myRandomArrayList.size(); i++) {
            if (myRandomArrayList.get(i) > max) {
                max = myRandomArrayList.get(i);
                index = i;
            }
        }
        System.out.println("The largest value is " + max + ", which is in slot " + index);
    }
}
