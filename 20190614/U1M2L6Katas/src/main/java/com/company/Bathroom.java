package com.company;

public class Bathroom extends Home{
    private float length;
    private float width;
    private float height;
    private boolean hasShower;
    private String flooringType;

    public Bathroom() {
    }

    public float calculateSqFt(float l, float w) {
        return super.calculateSqFt(l, w);
    }

    public void displayHeight(float x) {
        super.displayHeight(x);
    }

    public void displayFlooringType(String x) {
        super.displayFlooringType(x);
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public boolean isHasShower() {
        return hasShower;
    }

    public void setHasShower(boolean hasShower) {
        this.hasShower = hasShower;
    }

    public String getFlooringType() {
        return flooringType;
    }

    public void setFlooringType(String flooringType) {
        this.flooringType = flooringType;
    }
}
