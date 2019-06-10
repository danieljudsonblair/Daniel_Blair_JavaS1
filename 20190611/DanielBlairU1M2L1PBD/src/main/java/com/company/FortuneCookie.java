package com.company;

import java.util.Random;

public class FortuneCookie {
    public static void main(String[] args) {
        Random rand = new Random();
        int max = 54;
        int min = 1;
        int randFort = rand.nextInt((6 - 1) + 1) + 1;
        int random1 = rand.nextInt((max - min) + 1) + min;
        int random2 = random1;
        int random3 = random2;
        int random4 = random3;
        int random5 = random4;
        int random6 = random5;

        while (random2 == random1) {
            random2 = rand.nextInt((max - min) + 1) + min;
        }
        while (random3 == random2 || random3 == random1) {
            random3 = rand.nextInt((max - min) + 1) + min;
        }
        while (random4 == random3 || random4 == random2 || random4 == random1) {
            random4 = rand.nextInt((max - min) + 1) + min;
        }
        while (random5 == random4 || random5 == random3 || random5 == random2 || random5 == random1) {
            random5 = rand.nextInt((max - min) + 1) + min;
        }
        while (random6 == random5 || random6 == random4 || random6 == random3 || random6 == random2 || random6 == random1) {
            random6 = rand.nextInt((max - min) + 1) + min;
        }

        String fks = "Fortune cookie says: \"";
        if (randFort == 1)
            System.out.println(fks + "Your dog will find a bone.\"");
        else if (randFort == 2)
            System.out.println(fks + "Stick with your wife.\"");
        else if (randFort == 3)
            System.out.println(fks + "Happy year of the rooster!\"");
        else if (randFort == 4)
            System.out.println(fks + "Eat more sesame chicken!\"");
        else if (randFort == 5)
            System.out.println(fks + "Happy Chinese New Year!\"");
        else if (randFort == 6)
            System.out.println(fks + "May you live long and prosper!\"");

        System.out.println("   " + random1 + " - " + random2 + " - " + random3 + " - " + random4 + " - " + random5 + " - " + random6);

    }
}
