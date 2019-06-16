package com.company;

public class IceCreamShop {
    private String flavor;
    private float cupPrice = 2.50f;
    private float conePrice = 2.75f;
    private boolean isCup;
    private int numScoops;
    private float scoopPrice = 1.00f;
    private int numExtraToppings;
    private float extraToppingPrice = .75f;
    private float itemPrice;
    private float items;

    private IceCreamShop(String flavorIn, int numScoopsIn, int numXtraToppinsIn, boolean isCupIn){
        this.flavor = flavorIn;
        this.numScoops = numScoopsIn;
        this.numExtraToppings = numXtraToppinsIn;
        this.isCup = isCupIn;
    }

    private float calculateItemPrice(int numScoops, int numExtraToppings, boolean isCup) {
        if (isCup) {
            itemPrice = cupPrice + numScoops * scoopPrice + numExtraToppings * extraToppingPrice;
        } else {
            itemPrice = conePrice + numScoops * scoopPrice + numExtraToppings * extraToppingPrice;
        }
        items++;
        return itemPrice;
    }

    private String printItem(String flavor, boolean isCup){
        String coneOrCup;
        if (isCup) {
            coneOrCup = "cup";
        } else {
            coneOrCup = "cone";
        }
        return "The cost for your " + flavor + " " + coneOrCup + " is: $" + this.itemPrice + ".";
    }

    private void printTotalPrice(float[] arr) {
        float total = 0.0f;
        for (int i = 0; i < arr.length; i++) {
            total = total + arr[i];
        }
        System.out.printf("Total Price: $%.2f", total);
    }

    public static void main(String[] args) {
        IceCreamShop item = new IceCreamShop("Strawberry", 2, 1, true);
        IceCreamShop item2 = new IceCreamShop("Chocolate", 3, 2, false);
        float price1 = item.calculateItemPrice(item.numScoops, item.numExtraToppings, item.isCup);
        System.out.println(item.printItem(item.flavor, item.isCup));
        System.out.println();
        float price2 = item2.calculateItemPrice(item2.numScoops, item2.numExtraToppings, item2.isCup);
        System.out.println(item2.printItem(item2.flavor, item2.isCup));
        float[] totalArr = {price1, price2};
        item2.printTotalPrice(totalArr);
    }
}
