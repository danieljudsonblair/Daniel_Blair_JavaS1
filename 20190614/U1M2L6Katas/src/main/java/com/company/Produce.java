package com.company;

public class Produce extends Store {
    private String type;
    private float weight;
    private float lbsOnHand;

    public Produce(){
    }

    public int numLbsOnHand(int x) {
        return x;
    }

    public int reOrder(int x) {
        return super.reOrder(x);
    }

    public boolean reStock(boolean x) {
        return super.reStock(x);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getLbsOnHand() {
        return lbsOnHand;
    }

    public void setLbsOnHand(float lbsOnHand) {
        this.lbsOnHand = lbsOnHand;
    }
}
