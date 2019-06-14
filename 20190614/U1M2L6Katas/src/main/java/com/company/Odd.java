package com.company;

public class Odd extends Laptop {
    private String speed;
    private boolean isEngaged;

    public Odd() {
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public boolean isEngaged() {
        return isEngaged;
    }

    public void setEngaged(boolean engaged) {
        isEngaged = engaged;
    }

    public boolean spinUp(boolean x) {
        return x;
    }

    public boolean eject(boolean x) {
        return x;
    }
}
