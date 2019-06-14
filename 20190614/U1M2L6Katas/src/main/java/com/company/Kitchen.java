package com.company;

public class Kitchen extends Home {
    private float length;
    private float width;
    private float height;
    private boolean hasIsland;
    private String flooringType;
    private String counterTopType;

    public Kitchen() {
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

    public void displayHasIsland(boolean x) {
        System.out.println(x);
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

    public boolean isHasIsland() {
        return hasIsland;
    }

    public void setHasIsland(boolean hasIsland) {
        this.hasIsland = hasIsland;
    }

    public String getFlooringType() {
        return flooringType;
    }

    public void setFlooringType(String flooringType) {
        this.flooringType = flooringType;
    }

    public String getCounterTopType() {
        return counterTopType;
    }

    public void setCounterTopType(String counterTopType) {
        this.counterTopType = counterTopType;
    }
}
