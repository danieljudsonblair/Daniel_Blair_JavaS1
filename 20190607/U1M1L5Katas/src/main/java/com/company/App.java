package com.company;

public class App {

    public static int subtract (int a, int b) {
        return a - b;
    }

    public static int subtractOrZero (int a, int b) {
        if (a > b) {
            return a - b;
        } else {
            return 0;
        }
    }

    public static int max (int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        } else {
            return c;
        }
    }

    public static int min (int a, int b, int c) {
        if (a < b && a < c) {
            return a;
        } else if (b < a && b < c) {
            return b;
        } else {
            return c;
        }
    }

    public static boolean isLarger(int first, int second) {
        if (first > second) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(subtract(10, 20));
        System.out.println(subtractOrZero(10, 20));
        System.out.println(subtractOrZero(20, 10));
        System.out.println(max(1, 2, 3));
        System.out.println(max(1,3,2));
        System.out.println(max(2,1,3));
        System.out.println(max(2,3,1));
        System.out.println(max(3,1, 2));
        System.out.println(max(3,2,1));
        System.out.println(min(1,2, 3));
        System.out.println(min(1,3,2));
        System.out.println(min(2,1, 3));
        System.out.println(min(2,3, 1));
        System.out.println(min(3,2,1));
        System.out.println(min(3,1,2));
        System.out.println(isLarger(1,2));
        System.out.println(isLarger(2,1));
    }

}
