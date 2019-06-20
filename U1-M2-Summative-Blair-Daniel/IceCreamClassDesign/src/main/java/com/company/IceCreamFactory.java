package com.company;

public class IceCreamFactory {
    private String flavor;
    private float reqLbsOfMilk;
    private float reqLbsOfCream;
    private float reqLbsOfFlavor;
    private int mixTime;
    private int temperature;
    private float dailyTarget = 100f;
    private float lbsPerBatch;


    IceCreamFactory(String flavorIn, float reqLbsOfMilkIn, float reqLbsOfCreamIn, float reqLbsOfFlavorIn,
                    int mixTimeIn, int temperatureIn) {
        this.flavor = flavorIn;
        this.reqLbsOfMilk = reqLbsOfMilkIn;
        this.reqLbsOfCream = reqLbsOfCreamIn;
        this.reqLbsOfFlavor = reqLbsOfFlavorIn;
        this.mixTime = mixTimeIn;
        this.temperature = temperatureIn;
        this.lbsPerBatch = reqLbsOfMilkIn + reqLbsOfCreamIn + reqLbsOfFlavorIn;
    }

    private void setDailyTarget(float dailyTarget) {
        this.dailyTarget = dailyTarget;
    }

    private void printRecipe() {
        System.out.println("To make " + this.flavor + " ice cream, mix " + this.reqLbsOfMilk + " lbs of milk, "
                + this.reqLbsOfCream + " lbs of cream, and " + this.reqLbsOfFlavor + " lbs of flavor for "
                + this.mixTime + " minutes at " + this.temperature + " degrees.");
    }

    private void printCurrentNeed() {
        System.out.println("We need " + dailyTarget + " more lbs of " + this.flavor + " today.");
        System.out.printf("That's %.2f more batches \n", this.dailyTarget / this.lbsPerBatch);
    }

    private void makeABatch() {
        System.out.println("Making a batch of " + this.flavor + " ice cream.");
        this.dailyTarget = this.dailyTarget - this.lbsPerBatch;
    }

    public static void main(String[] args) {
        IceCreamFactory flavor1 = new IceCreamFactory("Strawberry", 10, 11.5f, 5, 90, 14);
        IceCreamFactory flavor2 = new IceCreamFactory("Rocky Road", 15, 12.5f, 7.5f, 75, 11);

        flavor1.setDailyTarget(250f);
        flavor1.printRecipe();
        flavor1.printCurrentNeed();
        flavor1.makeABatch();
        flavor1.printCurrentNeed();
        flavor1.makeABatch();
        flavor1.printCurrentNeed();

        flavor2.setDailyTarget(175f);
        flavor2.printRecipe();
        flavor2.printCurrentNeed();
        flavor2.makeABatch();
        flavor2.printCurrentNeed();
        flavor2.makeABatch();
        flavor2.printCurrentNeed();
    }
}
