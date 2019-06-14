package com.company;

public class Screen extends Laptop {
    private String resolution;
    private float size;
    private boolean isTouchscreen;

    public Screen() {
    }

    public void displayResolution(String x) {
        System.out.println(x);
    }

    public boolean toggleTouchscreen(boolean x) {
        return x;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public boolean isTouchscreen() {
        return isTouchscreen;
    }

    public void setTouchscreen(boolean touchscreen) {
        isTouchscreen = touchscreen;
    }
}
