package com.company;

public class SodaPop extends Store {
    private String manufacturer;
    private String flavor;
    private float size;
    private int unitsOnHand;

    public SodaPop() {
    }

    public int numOnHand(int x) {
        return super.numOnHand(x);
    }

    public int reOrder(int x) {
        return super.reOrder(x);
    }

    public boolean reStock(boolean x) {
        return super.reStock(x);
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

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public int getUnitsOnHand() {
        return unitsOnHand;
    }

    public void setUnitsOnHand(int unitsOnHand) {
        this.unitsOnHand = unitsOnHand;
    }
}
