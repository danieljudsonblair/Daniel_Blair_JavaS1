package com.company;

public class Restaurant extends Store {
    private String name;
    private String location;
    private float cashBalance;
    private Meat meat;
    private Produce produce;

    public Restaurant() {
    }


    public float calculateGrossSales(int[] x, float[] y) {
        return super.calculateGrossSales(x, y);
    }

    public boolean reorderMeat(float x) {
        return super.reorderMeat(x);
    }

    public boolean reorderProduce(float x) {
        return super.reorderProduce(x);
    }

    public boolean reOrderItem(int x) {
        return super.reOrderItem(x);
    }

    public boolean makeDeposit(float x) {
        return super.makeDeposit(x);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(float cashBalance) {
        this.cashBalance = cashBalance;
    }

    public Meat getMeat() {
        return meat;
    }

    public void setMeat(Meat meat) {
        this.meat = meat;
    }

    public Produce getProduce() {
        return produce;
    }

    public void setProduce(Produce produce) {
        this.produce = produce;
    }
}
