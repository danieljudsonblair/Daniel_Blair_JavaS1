package com.company;

public class VendingMachine extends Store {
    private String manufacturer;
    private boolean acceptsNonCash;
    private Gum gum;
    private Chocolate chocolate;
    private Chips chips;
    private Mints mints;
    private float cashBalance;
    private String location;

    public VendingMachine() {
    }

    public boolean reOrderItem(int x) {
        return super.reOrderItem(x);
    }

    public float calculateGrossSales(int[] x, float[] y) {
        return super.calculateGrossSales(x, y);
    }

    public boolean makeDeposit(float x) {
        return super.makeDeposit(x);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isAcceptsNonCash() {
        return acceptsNonCash;
    }

    public void setAcceptsNonCash(boolean acceptsNonCash) {
        this.acceptsNonCash = acceptsNonCash;
    }

    public Gum getGum() {
        return gum;
    }

    public void setGum(Gum gum) {
        this.gum = gum;
    }

    public Chocolate getChocolate() {
        return chocolate;
    }

    public void setChocolate(Chocolate chocolate) {
        this.chocolate = chocolate;
    }

    public Chips getChips() {
        return chips;
    }

    public void setChips(Chips chips) {
        this.chips = chips;
    }

    public Mints getMints() {
        return mints;
    }

    public void setMints(Mints mints) {
        this.mints = mints;
    }

    public float getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(float cashBalance) {
        this.cashBalance = cashBalance;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
