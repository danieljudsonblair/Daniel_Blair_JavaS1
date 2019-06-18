package com.company;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetIterator {

    public void printSet(int a, int b, int c, int d, int e){
        Set<Integer> temp = new HashSet<>();
        temp.add(a);
        temp.add(b);
        temp.add(c);
        temp.add(d);
        temp.add(e);

        temp = Collections.unmodifiableSet(temp);
        
        for(int i : temp) {
            System.out.println(i);
        }
    }
}
