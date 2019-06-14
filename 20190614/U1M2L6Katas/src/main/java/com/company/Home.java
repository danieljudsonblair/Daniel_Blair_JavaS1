package com.company;

public class Home {
    private Basement basement;
    private Kitchen kitchen;
    private Bathroom bathroom;
    private Bedroom bedroom;
    private Patio patio;
    private int numBedrooms;
    private int numBathrooms;
    private int price;
    private float totalSqFt;

    public Home() {
    }
    public void displayBedroomNum(int x) {
        System.out.println(x);
    }

    public void displayBathroomNum(float x) {
        System.out.println(x);
    }

    public float calculateTotalSqFt(float[] x) {
        return 0.0f;
    }

    public float calculateSqFt(float l, float w) {
        return l * w;
    }

    public void displayFlooringType(String x) {
        System.out.println(x);
    }

    public void displayHeight(float x) {
        System.out.println(x);
    }

    public float calculatePricePerSqFt(float totalSqFt) {
        return totalSqFt / price;
    }
}
