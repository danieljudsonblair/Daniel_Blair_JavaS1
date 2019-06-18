package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ClassmatesList {
    private ArrayList<Classmate> classmatesList = new ArrayList<>();


    public void add(Classmate classmate) {
        classmate.setName(classmate.getName());
        classmate.setHairColor(classmate.getHairColor());
    }

    public Classmate get(int num) {
        return classmatesList.get(num);
    }

    public ArrayList<Classmate> getAll() {
        return classmatesList;
    }

    public static void main(String[] args) {
        Classmate one = new Classmate();
        Classmate two = new Classmate();
        Classmate three = new Classmate();

        one.setName("Dan");
        one.setHairColor("Blonde");
        two.setName("Charity");
        two.setHairColor("Dark");
        three.setName("Bob");
        three.setHairColor("Black");

        ArrayList<Classmate> classmate = new ArrayList<>();

        classmate.add(one);
        classmate.add(two);
        classmate.add(three);
        System.out.println(classmate.get(0).getName());


    }

}
