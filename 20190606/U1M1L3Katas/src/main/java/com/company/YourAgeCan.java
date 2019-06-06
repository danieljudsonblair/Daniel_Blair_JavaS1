package com.company;

import java.util.Scanner;

public class YourAgeCan {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What is your age?");
        int age = Integer.parseInt(myScanner.nextLine());
        String vote = "vote";
        String drink = "drink alcohol";
        String president = "be president";
        String aarp = "aarp";
        String retire = "retire";
        String oct = "octogenarian";
        String cent = "century";

        if (age >= 18 && age < 21) {
            System.out.println("You can " + vote + "!");
        }
        else if (age >= 21 && age < 35) {
            System.out.println("You can " + vote + " and " + drink + "!");
        }
        else if (age >= 35 && age < 55) {
            System.out.println("You can " + vote + ", " + drink + ", and " + president + "!" );
        }
        else if (age >= 55 && age < 65) {
            System.out.println("You can " + vote + ", " + drink + ", " + president + ", and are eligible for " + aarp + "!");
        }
        else if ((age >=65 && age < 80) || (age >= 90 && age <100)) {
            System.out.println("You can " + vote + ", " + drink + ", " + president + ", are eligible for " + aarp + ", and can " + retire + "!");
        }
        else if (age >= 80 && age < 90) {
            System.out.println("You are an " + oct + " who can " + vote + ", " + drink + ", " + president + ", are eligible for " + aarp + ", and can " + retire + "!");
        }
        else if (age >= 100) {
            System.out.println("You can " + vote + ", " + drink + ", " + president + ", are eligible for " + aarp + ", can " + retire + ", and you're a " + cent + " old!");
        }
    }
}
