/*
  This class is written to test ConverterIf and ConverterSwitch class instantiations.
  Each test will loop until a "0" is entered.
  Order is as follows: ConverterIf.convertMonth(int month), ConverterIf.convertDay(int day),
  ConverterSwitch.convertMonth(int month), ConverterSwitch.convertDay(int day)
 */

/*
  INSTRUCTIONS AS PER GITLAB:
  Once you have your classes written, create a class called ConverterApplication
  which has your main method. In that main method, instantiate and use both the ConverterIf
  and ConverterSwitch classes.
 */
package com.company;
import java.util.Scanner;

public class ConverterApplication {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        // Instantiations
        ConverterIf ifTest = new ConverterIf();
        ConverterSwitch switchTest = new ConverterSwitch();
        // ================================================
        boolean isMonth = false;
        boolean isDay = false;
        int monthNum;
        int dayNum;

        // Use of ConverterIf instantiation:

        while (!isMonth) {
            System.out.print("Enter an integer 1-12: ");
            monthNum = myScanner.nextInt();
            System.out.println(ifTest.convertMonth(monthNum));
            if (monthNum == 0) {
                isMonth = true;
            }
        }

        isMonth = false;
        System.out.println();

        while (!isDay) {
            System.out.print("Enter an integer 1-7: ");
            dayNum = myScanner.nextInt();
            System.out.println(ifTest.convertDay(dayNum));
            if (dayNum == 0) {
                isDay = true;
            }
        }

        isDay = false;
        System.out.println();
        // =========================================================

        // Use of ConverterSwitch instantiation:

        while (!isMonth) {
            System.out.print("Enter an integer 1-12: ");
            monthNum = myScanner.nextInt();
            System.out.println(switchTest.convertMonth(monthNum));
            if (monthNum == 0) {
                isMonth = true;
            }
        }

        System.out.println();

        while (!isDay) {
            System.out.print("Enter an integer 1-7: ");
            dayNum = myScanner.nextInt();
            System.out.println(switchTest.convertDay(dayNum));
            if (dayNum == 0) {
                isDay = true;
            }
        }

        System.out.println();
        System.out.println("Have a nice Day!");
    }
}
