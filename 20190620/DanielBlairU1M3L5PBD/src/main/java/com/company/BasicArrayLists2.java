package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists2 {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> myRandomArrayList = new ArrayList<>();

        while (myRandomArrayList.size() < 10) {
            myRandomArrayList.add(rand.nextInt(99) + 1);
        }

        System.out.println("ArrayList: " + myRandomArrayList);
    }
}
