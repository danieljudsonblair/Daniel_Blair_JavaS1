package com.company;

import java.util.ArrayList;

public class ClassmatesList {
    private ArrayList<Classmate> classmatesList = new ArrayList<>();


    public void add(Classmate classmate) {
        classmatesList.add(classmate);
    }

    public Classmate get(int num) {
        return classmatesList.get(num);
    }

    public ArrayList<Classmate> getAll() {
        return classmatesList;
    }
}
