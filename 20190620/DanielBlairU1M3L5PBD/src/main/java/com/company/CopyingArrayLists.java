package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CopyingArrayLists {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> myRandomArrayList = new ArrayList<>();
        List<Integer> myRandomArrayListB = new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            if (i < 10) {
                myRandomArrayList.add(rand.nextInt(99) + 1);
                myRandomArrayListB.add(myRandomArrayList.get(i));
            } else {
                myRandomArrayList.set(i - 1, -7);
            }
        }
        System.out.println("ArrayList 1: " + myRandomArrayList);
        System.out.println("ArrayList 2: " + myRandomArrayListB);
    }
}
