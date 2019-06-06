package com.company;

import java.util.Scanner;
import java.text.DecimalFormat;


public class LoanCalculator {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("What is the amount of the mortgage?");
        double amt = myScanner.nextDouble();
        System.out.println("How many months is the term of the mortgage?");
        double term = myScanner.nextDouble();
        System.out.println("What is the annual interest rate of the mortgage?");
        double c = (myScanner.nextDouble() / 100) / 12;
        double payment = Math.floor(((Math.pow((1 + c), term) * c) * amt) / (Math.pow((1 + c), term) - 1) * 100) / 100;
        System.out.println("Your payment is $" + payment);
    }
}
