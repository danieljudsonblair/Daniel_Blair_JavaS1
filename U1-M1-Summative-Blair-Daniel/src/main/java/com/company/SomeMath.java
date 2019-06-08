package com.company;

public class SomeMath {

    public static int total5(int a, int b, int c, int d, int e) {
        int total;
        total = a + b + c + d + e;
        System.out.println(total);
        return total;
    }

    public static double average5(int a, int b, int c, int d, int e) {
        double avg = (a + b + c + d + e) / 5;
        System.out.println(avg);
        return avg;
    }

    public static double largest5(double a, double b, double c, double d, double e) {
        double [] arr = {a,b,c,d,e};
        double largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        System.out.println(largest);
        return largest;
    }

    public static void main(String[] args) {
        total5(1, 2, 3, 4, 5);
        average5(1,3,5,7,9);
        largest5(42.0, 35.1, 2.3, 40.2, 15.6);
    }
}
