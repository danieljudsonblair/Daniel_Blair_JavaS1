package com.company;

public class App {
    public static int total(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total = total + arr[i];

        }
        return total;
    }

    public static int totalOdd(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 1) {
                total = total + arr[i];
            }
        }
        return total;
    }

    public static int totalEven(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                total = total + arr[i];
            }
        }
        return total;
    }

    public static int secondLargestNumber(int[] arr) {
        int first = arr[0];
        int second = arr[1];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] < first && arr[i] > second) {
                second = arr[i];
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
        String holder;
        holder = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = holder;
        return arr;
    }

    public static String concatenateString(String[] arr) {
        String str = arr[0];
        for (int i = 1; i < arr.length; i++) {
            str = str + arr[i];
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

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 5) {
                ctr++;
            }
        }
        if (ctr > 0) {
            int[] arr2 = new int[ctr];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < 5) {
                    arr2[arr2.length - ctr] = arr[i];
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
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 5) {
                less++;
            } else {
                more++;
            }
        }
        int arr2[][] = new int[2][];
        arr2[0] = new int[less];
        arr2[1] = new int[more];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 5) {
                arr2[0][arr2[0].length - less] = arr[i];
                less--;
            } else {
                arr2[1][arr2[1].length - more] = arr[i];
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
        int totalArr[] = {1, 2, 3, 4, 5, 6};
        System.out.println(total(totalArr));
        System.out.println(totalOdd(totalArr));
        System.out.println(secondLargestNumber(totalArr));
    }
}

