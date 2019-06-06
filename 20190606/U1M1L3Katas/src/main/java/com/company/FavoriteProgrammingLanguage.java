package com.company;

import java.util.Scanner;

public class FavoriteProgrammingLanguage {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("What's your favorite programming language?");
        String fav = myScanner.nextLine();

        boolean isFavorite = false;

        while (!isFavorite) {
            if (fav.equals("Java")) {
                System.out.println("That's what I was looking for! Java is definitely the answer!");
                isFavorite = true;
            } else {
                System.out.println("Guess again!");
                fav = myScanner.nextLine();
            }
        }

    }
}
