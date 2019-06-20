/*
INSTRUCTIONS AS PER GITLAB:
In this exercise, you will create an object that has a set of methods that does addition,
subtraction, multiplication, and division for tow int parameters and a separate set of
methods that does the same for two double parameters. You will then instantiate the object
and use it to perform the following calculations. You must print out the calculation being
performed and the result of the calculation. For example: 2 + 2 = 4
Create your solution in an IntelliJ project called CalculatorObject.
*/

package com.company;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public double divide(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("1 + 1 = " + calculator.add(1, 1));
        System.out.println("23 - 52  = " + calculator.subtract(23, 52));
        System.out.println("34 * 2 = " + calculator.multiply(34, 2));
        System.out.println("12 / 3 = " + calculator.divide(12, 3));
        System.out.println("12 / 7 = " + calculator.divide(12, 7));
        System.out.println("3.4 + 2.3 = " + calculator.add(3.4, 2.3));
        System.out.println("6.7 * 4.4 = " + calculator.multiply(6.7, 4.4));
        System.out.println("5.5 - 0.5 = " + calculator.subtract(5.5, .5));
        System.out.println("10.8 / 2.2 = " + calculator.divide(10.8, 2.2));
    }
}
