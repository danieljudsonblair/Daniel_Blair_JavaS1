package com.company;

import java.util.Arrays;

public class App {

    public static int total(int[] arr) {
        int total = 0;
        for (int i : arr) {
            total += i;
        }
        return total;
    }


    public static int totalOdd(int[] arr) {
        int total = 0;
        for (int i = 1; i < arr.length; i+= 2) {
            total += arr[i];
        }
        return total;
    }


    public static int totalEven(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i+= 2) {
                total += arr[i];
        }
        return total;
    }


    public static int secondLargestNumber(int[] arr) {
        int first = arr[0];
        int second = arr[1];

        for (int i : arr) {
            if (i > first) {
                second = first;
                first = i;
            } else if (i < first && i > second) {
                second = i;
            }
        }
        return second;
    }


    public static int[] reverse(int[] arr) {
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[arr.length - 1 - i];
        }
        return arr2;
    }


    public static String[] swapFirstAndLast(String[] arr) {
        String holder = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = holder;
        return arr;
    }


    public static String concatenateString(String[] arr) {
        String str = "";
        for (String i : arr) {
            str += i;
        }
        return str;
    }


    public static int[] everyThird(int[] arr) {
        int[] arr2 = new int[arr.length / 3];
        if (arr.length < 3) {
            return null;
        } else {
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = arr[3 * i + 2];
            }
            return arr2;
        }
    }


    public static int[] lessThanFive(int[] arr) {
        int ctr = 0;

        for (int i : arr) {
            if (i < 5) {
                ctr++;
            }
        }
        if (ctr > 0) {
            int[] arr2 = new int[ctr];
            for (int i : arr) {
                if (i < 5) {
                    arr2[arr2.length - ctr] = i;
                    ctr--;
                }
            }
            return arr2;
        } else {
            return null;
        }
    }


    public static int[][] splitAtFive(int[] arr) {
        int less = 0;
        int more = 0;
        for (int i : arr) {
            if (i < 5) {
                less++;
            } else {
                more++;
            }
        }
        int arr2[][] = new int[2][];
        arr2[0] = new int[less];
        arr2[1] = new int[more];

        for (int i : arr) {
            if (i < 5) {
                arr2[0][arr2[0].length - less] = i;
                less--;
            } else {
                arr2[1][arr2[1].length - more] = i;
                more--;
            }
        }
        return arr2;
    }


    public static String[][] evensAndOdds(String[] arr) {
        int evens = 0;
        int odds = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                evens++;
            } else {
                odds++;
            }
        }
        String arr2[][] = new String[2][];
        arr2[0] = new String[evens];
        arr2[1] = new String[odds];

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr2[0][arr2[0].length - evens] = arr[i];
                evens--;
            } else {
                arr2[1][arr2[1].length - odds] = arr[i];
                odds--;
            }
        }
        return arr2;
    }


    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7};
        String[] strArr = {"foo", "bar", "baz", "qux"};
        System.out.println(total(arr));
        System.out.println(totalOdd(arr));
        System.out.println(totalEven(arr));
        System.out.println(secondLargestNumber(arr));
        System.out.println(Arrays.toString(swapFirstAndLast(strArr)));
        System.out.println(Arrays.toString(reverse(arr)));
        System.out.println(concatenateString(strArr));
        System.out.println(Arrays.toString(everyThird(arr)));
        System.out.println(Arrays.toString(lessThanFive(arr)));
        System.out.println(Arrays.deepToString(splitAtFive(arr)));
        System.out.println(Arrays.deepToString(evensAndOdds(strArr)));
    }
}

