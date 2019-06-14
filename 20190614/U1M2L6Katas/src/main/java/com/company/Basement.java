package com.company;

public class Basement extends Home {
    private float length;
    private float width;
    private float height;
    private boolean isFinished;
    private String flooringType;



    public Basement() {
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

    public void displayFinishedStatus(boolean x) {
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

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public String getFlooringType() {
        return flooringType;
    }

    public void setFlooringType(String flooringType) {
        this.flooringType = flooringType;
    }
}
