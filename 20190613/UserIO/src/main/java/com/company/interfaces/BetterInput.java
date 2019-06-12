package com.company.interfaces;

import java.util.Scanner;

public class BetterInput implements UserIO {
    Scanner myScanner = new Scanner(System.in);

    public int readInt(String prompt) {
        System.out.println(prompt);
        try {
            return Integer.parseInt(myScanner.nextLine());
        } catch (Exception e) {
            System.out.println("Not an int.. try again");
            return readInt(prompt);
        }
    }

    public long readLong(String prompt) {
        System.out.println(prompt);
        try {
            return Integer.parseInt(myScanner.nextLine());
        } catch (Exception e) {
            System.out.println("Not a long.. try again");
            return readLong(prompt);
        }
    }

    public double readDouble(String prompt) {
        System.out.println(prompt);
        try {
            return Double.parseDouble(myScanner.nextLine());
        } catch (Exception e) {
            System.out.println("Not a double.. try again");
            return readDouble(prompt);
        }
    }

    public float readFloat(String prompt) {
        System.out.println(prompt);
        try {
            return Float.parseFloat(myScanner.nextLine());
        } catch (Exception e) {
            System.out.println("Not a float.. try again");
            return readFloat(prompt);
        }
    }

    public String readString(String prompt) {
        System.out.println(prompt);
        try {
            return myScanner.nextLine();
        } catch (Exception e){
            System.out.println("Not a string.. try again");
            return readString(prompt);
        }
    }
}
