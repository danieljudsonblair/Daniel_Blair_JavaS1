package com.company;

public class ComputerMouse {
    private String manufacturer;
    private String model;
    private int xPosition;
    private int yPosition;
    private int[] lastClickedLocation = new int[2];

    public ComputerMouse(String manufacturerIn, String modelIn, int xPositionIn, int yPositionIn, int[] lastClickedLocationIn) {
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.xPosition = xPositionIn;
        this.yPosition = yPositionIn;
        this.lastClickedLocation = lastClickedLocationIn;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public int[] getLastClickedLocation() {
        return lastClickedLocation;
    }

    public void move(int deltaX, int deltaY) {
        this.xPosition = xPosition + deltaX;
        this.yPosition = yPosition + deltaY;
    }

    public void click() {
        System.out.println("Click");
    }

}
