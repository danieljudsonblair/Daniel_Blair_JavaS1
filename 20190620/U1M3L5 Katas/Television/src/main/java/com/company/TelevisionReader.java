package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.*;

/*
    This kata was pair-programmed with Maria Wong as per instructed by Kesh.
 */

public class TelevisionReader {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Television> tvList;

            tvList = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>() {});

            //Find all televisions with a screen size greater than 60 inches. Use the `.forEach`
            // method to print out all entries.
            tvList.stream()
                    .filter(t -> t.getScreenSize() > 60)
                    .forEach(t -> {
                        System.out.println("Brand: " + t.getBrand());
                        System.out.println("Model: " + t.getModel());
                        System.out.println("Price: $" + t.getPrice());
                        System.out.println("Screen Size: " + t.getScreenSize());
                        System.out.println();
                    });


            //Group all televisions into a `Map` by `brand`. Print out the list of manufacturers.
            Map<String, List<Television>> brandMap =
                    tvList.stream()
                        .collect(Collectors.groupingBy(t -> t.getBrand()));

                        Set<String> tvKeys = brandMap.keySet();
                        tvKeys.forEach(System.out::println);

            //Find and display the average `screenSize`.
            double avgSize = tvList.stream()
                    .mapToInt(t -> t.getScreenSize())
                    .average()
                    .getAsDouble();

            System.out.println("\nAverage Screen Size: " + avgSize);

            //Find and display the largest screen.
            int largestSize = tvList.stream()
                    .mapToInt(t -> t.getScreenSize())
                    .max()
                    .getAsInt();

            System.out.println("\nLargest Screen Size: " + largestSize + "\n");

            //sorted
            tvList.stream()
                    .sorted(Comparator.comparing(Television::getScreenSize))
                    .forEach(t -> System.out.println(t.getScreenSize() + " " + t.getBrand() ));

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }

    }

}
