package com.company.interfaces;

import java.util.Scanner;

public class Input implements UserIO {
    Scanner myScanner = new Scanner(System.in);

    public int readInt(String prompt){
        System.out.println(prompt);
        int x = myScanner.nextInt();
                return x;
    }
    public long readLong(String prompt){
        System.out.println(prompt);
        long x = myScanner.nextLong();
        return x;
    }
    public double readDouble(String prompt){
        System.out.println(prompt);
        double x = myScanner.nextDouble();
        return x;
    }
    public float readFloat(String prompt){
        System.out.println(prompt);
        float x = myScanner.nextFloat();
        return x;
    }
    public String readString(String prompt){
        System.out.println(prompt);
        String x = myScanner.next();
        return x;
    }
}
