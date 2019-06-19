package com.company;

import java.util.ArrayList;
import java.util.List;

public class BasicArrayLists1 {
    public static void main(String[] args) {
        List<Integer> myArrayList = new ArrayList<>();

        while (myArrayList.size() < 10) {
            myArrayList.add(-113);
        }

        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println("Slot " + i + " contains a " + myArrayList.get(i));
        }
    }
}
