package com.company;

public class Store {
    private String name;
    private String location;
    private VendingMachine vendingMachine;
    private Gum gum;
    private Popcorn popcorn;
    private Chocolate chocolate;
    private Mints mints;
    private SodaPop soda;
    private Chips chips;
    private Meat meat;
    private Produce produce;

    public Store() {
    }

    public int numOnHand(int x) {
        return x;
    }

    public boolean reStock(boolean x) {
        return x;
    }

    public boolean reOrderItem(int x) {
        return false;
    }

    public boolean reorderMeat(float x) {
        return false;
    }

    public boolean reorderProduce(float x) {
        return false;
    }

    public float calculateGrossSales(int[] x, float[] y) {
        return 0.0f;
    }

    public boolean makeDeposit(float x) {
        return false;
    }
}
