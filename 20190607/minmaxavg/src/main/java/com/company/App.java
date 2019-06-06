package com.company;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Set up the scanner and variables
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10]; // initializes an array of 10 ints with default values 0 @ each index
        String stringIn;  // declaring stringIn variable
        int min;  // declares min variable of type int
        int max;  // declares max variable of type int
        int sum = 0; //  declares & initializes sum of type int to value 0
        double avg; // declares avg variable of type double

        // Read in 10 ints
        for (int i = 0; i < numbers.length; i++) { // sets up loop to run for each index of array

            System.out.println("Please enter a number:"); // prompts user
            stringIn = scanner.nextLine(); // scans user input
            numbers[i] = Integer.parseInt(stringIn); // parses input and saves to index i of numbers array
        }

        // Calculate min
        min = numbers[0];  // initializes min to value @ numbers index 0
        for (int i = 0; i < numbers.length; i++) { // for each value of index i of numbers array
            if (numbers[i] < min) { // if int @ numbers index i < min
                min = numbers[i];  // min is reassigned to int @ numbers index i
            }
        }

        // Calculate max
        max = numbers[0];  // initializes max to value @ numbers index 0
        for (int i = 0; i < numbers.length; i++) {  // for each value of index i of numbers array
            if (numbers[i] > max) {  // if int @ numbers index i > max
                max = numbers[i];  //  max is reassigned to int @ numbers index i
            }
        }

        // Calculate average
        for (int i = 0; i < numbers.length; i++) { // for each value @ index i of numbers array
            sum += numbers[i];  // add the value of numbers[i] to sum
        }

        avg = sum/(double)numbers.length; // calculate avg by dividing sum by array length

        System.out.println("Minimum value: " + min);  // Print calculated values
        System.out.println("Maximum value: " + max);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);
    }

}
