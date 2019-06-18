package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class JSONWriteAndRead {
    public static void main(String[] args) {
        PrintWriter writer = null;

        List<Car> carList = new ArrayList<>();
        List<Car> carList2;

        carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
        carList.add(new Car(2001, "Honda", "Civic", "Silver"));
        carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
        carList.add(new Car(1964, "Ford", "Mustang", "Red"));

        ObjectMapper mapper = null;

        try {
            mapper = new ObjectMapper();
            String jsonCarList = mapper.writeValueAsString(carList);
            writer = new PrintWriter(new FileWriter("cars.json"));
            writer.println(jsonCarList);
        } catch (JsonProcessingException e) {
            System.out.println("Error! trouble converting object to json string. " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error! Cannot write to file. " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }

        try {
            carList2 = mapper.readValue(
                    new File("cars.json"),
                    new TypeReference<List<Car>>() {
                    });
            for (Car car : carList2) {
                System.out.println("===========================");
                System.out.println(car.getYear());
                System.out.println(car.getMake());
                System.out.println(car.getModel());
                System.out.println(car.getColor());
            }
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}