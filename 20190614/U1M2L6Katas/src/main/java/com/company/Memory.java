package com.company;

public class Memory extends Laptop {
    private String ramCapacity;
    private String hdCapacity;
    private boolean isSolidState;


    public Memory() {
    }

    public void displayRamCapacity(String x) {
        System.out.println(x);
    }

    public void displayHdCapacity(String x) {
        System.out.println(x);
    }

    public void displayHDType(boolean x) {
        System.out.println(x);
    }

    public String getRamCapacity() {
        return ramCapacity;
    }

    public void setRamCapacity(String ramCapacity) {
        this.ramCapacity = ramCapacity;
    }

    public String getHdCapacity() {
        return hdCapacity;
    }

    public void setHdCapacity(String hdCapacity) {
        this.hdCapacity = hdCapacity;
    }

    public boolean isSolidState() {
        return isSolidState;
    }

    public void setSolidState(boolean solidState) {
        isSolidState = solidState;
    }

    public void displayManufacturer(String man) {
        System.out.println(man);
    }
    public void displayProcessor(String pro) {
        System.out.println(pro);
    }
    public void displayNumCores(int cores) {
        System.out.println(cores);
    }

}
