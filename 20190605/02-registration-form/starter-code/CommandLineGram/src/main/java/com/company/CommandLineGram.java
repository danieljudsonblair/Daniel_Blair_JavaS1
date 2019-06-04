package com.company;

import java.util.Scanner;

public class CommandLineGram {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What is your first name?");
        String nameFirst = myScanner.nextLine();

        System.out.println("What is your last name?");
        String nameLast = myScanner.nextLine();

        System.out.println("What is your email?");
        String email = myScanner.nextLine();

        System.out.println("What is your Twitter handle?");
        String twitter = myScanner.nextLine();

        System.out.println("What is your age?");
        String age = myScanner.nextLine();

        System.out.println("What country do you live in?");
        String country = myScanner.nextLine();

        System.out.println("What is your profession?");
        String profession = myScanner.nextLine();

        System.out.println("What is your favorite OS?");
        String opSys = myScanner.nextLine();

        System.out.println("What is your favorite programming language?");
        String language = myScanner.nextLine();

        System.out.println("Who is your favorite computer scientist?");
        String scientist = myScanner.nextLine();

        System.out.println("What is your favorite keyboard shortcut?");
        String shortcut = myScanner.nextLine();

        System.out.println("Have you ever built your own computer?");
        String computer = myScanner.nextLine();

        System.out.println("If you could be any superhero, who would it be?");
        String superHero = myScanner.nextLine();

        System.out.println("Your first name is: " + nameFirst);
        System.out.println("Your last name is: " + nameLast);
        System.out.println("Your email is: " + email);
        System.out.println("Your twitter handle is: " + twitter);
        System.out.println("Your age is: " + age);
        System.out.println("Your country is: " + country);
        System.out.println("Your profession is: " + profession);
        System.out.println("Your favorite OS is: " + opSys);
        System.out.println("Your favorite programming laguage is: " + language);
        System.out.println("Your favorite computer scientist is: " + scientist);
        System.out.println("Your favorite keyboard shortcut is: " + shortcut);
        System.out.println("Your response to building a computer is: " + computer);
        System.out.println("The superhero you want to be is: " + superHero);
    }
}