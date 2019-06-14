package com.company;

public class Processor extends Laptop {
    private String manufacturer;
    private String speed;
    private int cores;

    public Processor() {
    }

    public void displayManufacturer(String x) {
        System.out.println(x);
    }

    public void displaySpeed(String x) {
        System.out.println(x);
    }

    public void displayNumCores(int x) {
        System.out.println(x);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }
}
