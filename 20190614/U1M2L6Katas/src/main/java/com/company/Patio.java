package com.company;

public class Patio extends Home {
    private float length;
    private float width;
    private boolean isEnclosed;
    private String flooringType;
    private boolean hasFireplace;

    public Patio() {
    }

    public float calculateSqFt(float l, float w) {
        return super.calculateSqFt(l, w);
    }

    public void displayFlooringType(String x) {
        super.displayFlooringType(x);
    }

    public void displayHasFireplace(boolean x) {
        System.out.println(x);
    }

    public void displayIsEnclosed(boolean x) {
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

    public boolean isEnclosed() {
        return isEnclosed;
    }

    public void setEnclosed(boolean enclosed) {
        isEnclosed = enclosed;
    }

    public String getFlooringType() {
        return flooringType;
    }

    public void setFlooringType(String flooringType) {
        this.flooringType = flooringType;
    }

    public boolean isHasFireplace() {
        return hasFireplace;
    }

    public void setHasFireplace(boolean hasFireplace) {
        this.hasFireplace = hasFireplace;
    }
}
