package com.company;

import java.util.*;

public class App {

    public void printKeys(Map<String, String> map) {
        Set<String> myKeys = map.keySet();
        for (String key : myKeys) {
            System.out.println("Key = " + key);
        }
    }

    public void printValues(Map<String, String> map) {
        Collection<String> myValues = map.values();
        for (String value : myValues) {
            System.out.println(value);
        }
    }

    public void printKeysAndValues(Map<String, String> map) {
        Set<Map.Entry<String, String>> myEntries = map.entrySet();
        for (Map.Entry<String, String> entry : myEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public Map<String, Integer> mapFun(Map<String, Integer> map) {
        map.put("Ford Explorer", 2012);
        map.put("Smart Fortwo", 2013);
        map.remove("Jeep Wrangler");
        return map;
    }

    public Map<String, List<Car>> listCars(List<Car> car) {
        List<Car> toyotaList = new ArrayList<>();
        List<Car> fordList = new ArrayList<>();
        List<Car> hondaList = new ArrayList<>();

        Map<String, List<Car>> map = new HashMap<>();
        for (Car item : car) {
            if (item.getMake().equals("Toyota")) {
                toyotaList.add((Car) item);
            } else if (item.getMake().equals("Ford")) {
                fordList.add((Car) item);
            } else if (item.getMake().equals("Honda")) {
                hondaList.add((Car) item);
            }
        }
        map.put("Toyota", toyotaList);
        map.put("Ford", fordList);
        map.put("Honda", hondaList);
        return map;
    }
}
