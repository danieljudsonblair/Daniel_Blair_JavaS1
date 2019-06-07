package com.company;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("##.##");     // Added to format decimals
        df.setRoundingMode(RoundingMode.DOWN);                     // Added to round decimals
        Scanner scan = new Scanner(System.in);

        System.out.print("What is the width of the driveway in feet? ");
        float width = Float.parseFloat(scan.nextLine());           // Changed type to float and use parseFloat method

        System.out.print("What is the length of the driveway in feet? ");
        float length = Float.parseFloat(scan.nextLine());          // Changed type to float and use parseFloat method

//        float cementCost = 0.0f;    <- removed to be declared and initialized below
//        float framingCost = 0.0f;   <- removed to be declared and initialized below

        System.out.print("What is the cost of cement per square foot? ");
        float cementCost = Float.parseFloat(scan.nextLine());      // added type to variable declaration and calculation

        System.out.print("What is the cost of framing/footers per linear foot? ");
        float framingCost = Float.parseFloat(scan.nextLine());           //  Changed cementCost to framingCost; added type to variable declaration and calculation

        float area = length * width;                               // Changed to type float
        float perimeter = 2 * length + 2 * width;                  // Changed to type float, changed operator from - to +

        System.out.format("The area of the driveway is " + df.format(area) + " square feet. %n");    // Changed display format
        System.out.format("The perimeter of the driveway is " + df.format(perimeter) + " feet. %n"); // Changed display format & suffix

        System.out.format("The cost of the cement is $" + df.format(area * cementCost) + "%n");                // Changed display format
        System.out.format("The cost of the framing/footers is $" + df.format(perimeter * framingCost) + "%n"); // Changed display format and calculation
    }
}
