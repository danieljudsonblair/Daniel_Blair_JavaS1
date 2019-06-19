package com.company;

import java.util.ArrayList;
import java.util.List;

public class BasicArrayLists0 {
    public static void main(String[] args) {
        List<Integer> myArrayList = new ArrayList<>();
        myArrayList.add(0, -113);
        myArrayList.add(1, -113);
        myArrayList.add(2, -113);
        myArrayList.add(3, -113);
        myArrayList.add(4, -113);
        myArrayList.add(5, -113);
        myArrayList.add(6, -113);
        myArrayList.add(7, -113);
        myArrayList.add(8, -113);
        myArrayList.add(9, -113);

        System.out.println("Slot 0 contains a " + myArrayList.get(0));
        System.out.println("Slot 1 contains a " + myArrayList.get(1));
        System.out.println("Slot 2 contains a " + myArrayList.get(2));
        System.out.println("Slot 3 contains a " + myArrayList.get(3));
        System.out.println("Slot 4 contains a " + myArrayList.get(4));
        System.out.println("Slot 5 contains a " + myArrayList.get(5));
        System.out.println("Slot 6 contains a " + myArrayList.get(6));
        System.out.println("Slot 7 contains a " + myArrayList.get(7));
        System.out.println("Slot 8 contains a " + myArrayList.get(8));
        System.out.println("Slot 9 contains a " + myArrayList.get(9));
    }
}
