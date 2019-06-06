package com.company;


import java.util.Random;
import java.util.Scanner;

public class HowManyTimesToSeven {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Enter the number of rolls:");

        int rolls = Integer.parseInt(myScanner.nextLine());

        short max = 6;
        short min = 1;
        short two = 0;
        short three = 0;
        short four = 0;
        short five = 0;
        short six = 0;
        short seven = 0;
        short eight = 0;
        short nine = 0;
        short ten = 0;
        short eleven = 0;
        short twelve = 0;
        boolean sevenRoll = false;


        for (int i = 1; i <= rolls; i++) {

            int random = (rand.nextInt((max - min) + 1) + min) + (rand.nextInt((max - min) + 1) + min);
            switch (random) {
                case 2:
                    two++;
                    break;
                case 3:
                    three++;
                    break;
                case 4:
                    four++;
                    break;
                case 5:
                    five++;
                    break;
                case 6:
                    six++;
                    break;
                case 7:
                    if (sevenRoll == false) {
                        System.out.println("==============================");
                        System.out.println("It took you " + i + " rolls to get 7");
                        sevenRoll = true;
                    }
                    seven++;
                    break;
                case 8:
                    eight++;
                    break;
                case 9:
                    nine++;
                    break;
                case 10:
                    ten++;
                    break;
                case 11:
                    eleven++;
                    break;
                case 12:
                    twelve++;
                    break;
            }
        }
        System.out.println("You rolled " + rolls + " times");
        System.out.println("==============================");
        System.out.println("You rolled 2 " + two + " times");
        System.out.println("You rolled 3 " + three + " times");
        System.out.println("You rolled 4 " + four + " times");
        System.out.println("You rolled 5 " + five + " times");
        System.out.println("You rolled 6 " + six + " times");
        System.out.println("You rolled 7 " + seven + " times");
        System.out.println("You rolled 8 " + eight + " times");
        System.out.println("You rolled 9 " + nine + " times");
        System.out.println("You rolled 10 " + ten + " times");
        System.out.println("You rolled 11 " + eleven + " times");
        System.out.println("You rolled 12 " + twelve + " times");
        System.out.println("==============================");
    }
}