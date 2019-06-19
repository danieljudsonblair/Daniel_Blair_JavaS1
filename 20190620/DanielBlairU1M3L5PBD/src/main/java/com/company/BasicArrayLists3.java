package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists3 {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> myRandomArrayList = new ArrayList<>();

        while (myRandomArrayList.size() < 1000) {
            myRandomArrayList.add(rand.nextInt(89) + 10);
        }

        System.out.println(myRandomArrayList);
    }
}
