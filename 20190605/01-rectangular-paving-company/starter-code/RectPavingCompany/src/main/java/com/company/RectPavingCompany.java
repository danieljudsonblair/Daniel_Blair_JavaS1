package com.company;

import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter the width of your driveway in feet");
        int width = myScanner.nextInt();

        System.out.println("What is the length of the driveway in feet?");
        int length = myScanner.nextInt();

        System.out.println("What is the cost of the cement per square foot?");
        float cementCost = myScanner.nextFloat();

        System.out.println("What is the cost of the framing/footers per foot?");
        float framingCost = myScanner.nextFloat();

        int area = length * width;
        int perimeter = 2 * length + 2 * width;
        float cement = cementCost * area;
        float framing = framingCost * perimeter;

        System.out.println("The area of your driveway is: " + area);
        System.out.println("The perimeter of the driveway is: " + perimeter);
        System.out.println("The subtotal cost of cement is: $");
        System.out.printf("%.2f", cement);
        System.out.println("The subtotal cost of framing is: $");
        System.out.printf("%.2f", framing);

    }
}


