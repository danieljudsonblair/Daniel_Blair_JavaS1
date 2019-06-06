package com.company;

import java.util.Scanner;

public class AgeAgain {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("What is your age?");
        int age = Integer.parseInt(myScanner.nextLine());

        if (age < 14) {
            System.out.println("What grade are you in?");
            String grade = myScanner.nextLine();
            System.out.println("Wow! " + grade + " grade - that sounds exciting!");
        } else if (age >= 14 && age <= 18) {
            System.out.println("Are you planning on going to college?");
            String colYN = myScanner.nextLine();
            if (colYN.equals("yes")) {
                System.out.println("What college?");
                String colAns = myScanner.nextLine();
                System.out.println(colAns + " is a great school!");
            } else if (colYN.equals("no")) {
                System.out.println("What do you want to do after high school?");
                String postHS = myScanner.nextLine();
                System.out.println("Wow, " + postHS + " sounds like a plan!");
            }
        } else {
            System.out.println("What is your job?");
            String job = myScanner.nextLine();
            System.out.println(job + " sounds like a great job!");

        }
    }
}
