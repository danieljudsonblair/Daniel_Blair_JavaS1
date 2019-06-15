package com.company;

public class Calculations {
    public static void main(String[] args) {
        Calculator addInt = new Calculator();
        Calculator addDoub = new Calculator();
        Calculator subInt = new Calculator();
        Calculator subDoub = new Calculator();
        Calculator multInt = new Calculator();
        Calculator multDoub = new Calculator();
        Calculator divInt = new Calculator();
        Calculator divDoub = new Calculator();

        addInt.add(1, 1);
        subInt.subtract(23, 52);
        multInt.multiply(34, 2);
        divInt.divide(12, 3);
        divInt.divide(12, 7);
        addDoub.add(3.4, 2.3);
        multDoub.multiply(6.7, 4.4);
        subDoub.subtract(5.5, .5);
        divDoub.divide(10.8, 2.2);
    }
}
