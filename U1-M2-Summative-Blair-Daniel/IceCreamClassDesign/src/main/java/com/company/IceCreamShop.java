package com.company;

public class IceCreamShop {
    private String flavor;
    private float cupPrice = 1.50f;
    private float conePrice = 1.75f;
    private boolean isCup;
    private int numScoops;
    private float scoopPrice = 1.00f;
    private int numExtraToppings;
    private float extraToppingPrice = .75f;
    private float itemPrice;

    private IceCreamShop(String flavorIn, boolean isCupIn, int numScoopsIn, int numXtraToppinsIn) {
        this.flavor = flavorIn;
        this.numScoops = numScoopsIn;
        this.numExtraToppings = numXtraToppinsIn;
        this.isCup = isCupIn;
        this.itemPrice = calculateItemPrice(numScoopsIn, numXtraToppinsIn, isCupIn);
        printItem(flavorIn, isCupIn);
    }

    private float calculateItemPrice(int numScoops, int numExtraToppings, boolean isCup) {
        if (isCup) {
            itemPrice = cupPrice + numScoops * scoopPrice + numExtraToppings * extraToppingPrice;
        } else {
            itemPrice = conePrice + numScoops * scoopPrice + numExtraToppings * extraToppingPrice;
        }
        return itemPrice;
    }

    private void printItem(String flavor, boolean isCup) {
        String coneOrCup;
        String extraToppingsMsg;
        if (isCup) {
            coneOrCup = "cup";
        } else {
            coneOrCup = "cone";
        }
        if (this.numExtraToppings > 0) {
            extraToppingsMsg = "and " + this.numExtraToppings + " extra toppings ";
        } else {
            extraToppingsMsg = "";
        }
        System.out.printf("The cost for your " + flavor + " " + coneOrCup + " with " + this.numScoops + " scoops " + extraToppingsMsg + "is: $%.2f" + ".\n",  + this.itemPrice);
    }

    // Getters and Setters to get and set base cup, cone, toppings, and scoop price

    public float getCupPrice() {
        return cupPrice;
    }

    public void setCupPrice(float cupPrice) {
        this.cupPrice = cupPrice;
    }

    public float getConePrice() {
        return conePrice;
    }

    public void setConePrice(float conePrice) {
        this.conePrice = conePrice;
    }

    public float getScoopPrice() {
        return scoopPrice;
    }

    public void setScoopPrice(float scoopPrice) {
        this.scoopPrice = scoopPrice;
    }

    public float getExtraToppingPrice() {
        return extraToppingPrice;
    }

    public void setExtraToppingPrice(float extraToppingPrice) {
        this.extraToppingPrice = extraToppingPrice;
    }

    public static void main(String[] args) {
        IceCreamShop iceCreamCone = new IceCreamShop("Chocolate", false, 3,0);
        IceCreamShop iceCreamCup = new IceCreamShop("Strawberry", true, 2, 2);
    }
}
