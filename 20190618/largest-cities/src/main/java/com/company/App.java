package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        City newYork = new City("New York", 8654321);
        City losAngeles = new City("Los Angeles", 4563218);
        City chicago = new City("Chicago", 2716520);
        City denver = new City("Denver", 704621);
        City desMoines = new City("Des Moines", 217521);
        City atlanta = new City("Atlanta", 486213);

        Map<String, City> def = new HashMap<>();
        def.put("New York", newYork);
        def.put("California", losAngeles);
        def.put("Illinois", chicago);
        def.put("Colorado", denver);
        def.put("Iowa", desMoines);
        def.put("Georgia", atlanta);

        Set<String> myKeys = def.keySet();
        for (String key : myKeys) {
            System.out.println("Key = " + key + " : Value = " + def.get(key).getName() + " " + def.get(key).getPopulation());
        }

        System.out.print("Enter min population:");
        long min = myScanner.nextLong();

        for (String key : myKeys) {
            if (min >= def.get(key).getPopulation()) {
                System.out.println(key);
            }
        }
    }
}
