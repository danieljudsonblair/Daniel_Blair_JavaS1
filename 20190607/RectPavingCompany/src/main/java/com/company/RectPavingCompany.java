package com.company;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("##.##");  // Added to format decimals
        df.setRoundingMode(RoundingMode.DOWN);                  // Added to format decimals
        Scanner scan = new Scanner(System.in);

        System.out.print("What is the width of the driveway in feet? ");
        float width = Float.parseFloat(scan.nextLine());  // Changed type to float and used parseFloat method

        System.out.print("What is the length of the driveway in feet? ");
        float length = Float.parseFloat(scan.nextLine()); // Changed type to float and used parseFloat method

        float cementCost = 0.0f;
        float framingCost = 0.0f;

        System.out.print("What is the cost of cement per square foot? ");
        cementCost = Float.parseFloat(scan.nextLine());

        System.out.print("What is the cost of framing/footers per linear foot? ");
        framingCost = Float.parseFloat(scan.nextLine());  //  Changed to framingCost

        float area = length * width;                // Changed to type float
        float perimeter = 2 * length + 2 * width;   // Changed to type float, fixed calculation

        System.out.format("The area of the driveway is " + df.format(area) + " square feet. %n");   // Changed format
        System.out.format("The perimeter of the driveway is " + df.format(perimeter) + " feet. %n"); // Changed format & suffix

        System.out.format("The cost of the cement is $" + df.format(area * cementCost) + "%n");  // Changed format
        System.out.format("The cost of the framing/footers is $" + df.format(perimeter * framingCost) + "%n"); // Changed format and calc
    }
}
