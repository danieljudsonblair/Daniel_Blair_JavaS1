package com.company;

import java.util.Scanner;

public class SpaceBoxing {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.print("Please enter your current earth weight: ");
        int earthWeight = myScanner.nextInt();

        System.out.println("\n" + "I have information for the following planets:");
        System.out.println("   1. Venus   2. Mars    3. Jupiter");
        System.out.println("   4. Saturn  5. Uranus  6. Neptune");
        System.out.println("                                   ");
        System.out.print("Which planet are you visiting? ");

        int planet = myScanner.nextInt();
        float weight;
        switch (planet) {
            case 1:
                weight = earthWeight * .78f;
                break;
            case 2:
                weight = earthWeight * .39f;
                break;
            case 3:
                weight = earthWeight * 2.65f;
                break;
            case 4:
                weight = earthWeight * 1.17f;
                break;
            case 5:
                weight = earthWeight * 1.05f;
                break;
            case 6:
                weight = earthWeight * 1.23f;
                break;
            default:
                weight = earthWeight;
        }
        System.out.printf("\n" + "Your weight would be %.2f pounds on that planet.", weight);
    }
}
