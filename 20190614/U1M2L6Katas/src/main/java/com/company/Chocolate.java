package com.company;

public class Chocolate extends VendingMachine {
    private String manufacturer;
    private boolean hasNuts;
    private float weight;
    private int unitsOnHand;

    public Chocolate() {
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

    public boolean isHasNuts() {
        return hasNuts;
    }

    public void setHasNuts(boolean hasNuts) {
        this.hasNuts = hasNuts;
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
