package com.company;

public class Popcorn extends VendingMachine {
    private String manufacturer;
    private String flavor;
    private float weight;
    private int unitsOnHand;

    public Popcorn() {
    }

    public int numOnHand(int x) {
        return super.numOnHand(x);
    }

    public boolean reStock(boolean x) {
        return super.reStock(x);
    }

    public int reOrder(int x) {
        return super.reOrder(x);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getUnitsOnHand() {
        return unitsOnHand;
    }

    public void setUnitsOnHand(int unitsOnHand) {
        this.unitsOnHand = unitsOnHand;
    }
}
