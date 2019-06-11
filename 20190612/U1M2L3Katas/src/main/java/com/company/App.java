package com.company;

public class App {
    public TV createTV() {
        TV tv = new TV("Zenith", "U2121H", 83, "NBC", 55, false);
        return tv;
    }

    public Car createCar() {
        Car car = new Car("Honda", "Accord", "Sedan", "Blue", "2.6L V6", "CVT", 4, 31.7, 25218);
        return car;
    }

    public Radio createRadio() {
        Radio radio = new Radio("Sony", "V32", 2, "WUNV", 30, true);
        return radio;
    }

    public Microwave createMicrowave() {
        Microwave microwave = new Microwave("Haier", "X1200w", 45, "12:00", false);
        return microwave;
    }

    public CoffeeMaker createCoffeeMaker() {
        CoffeeMaker coffeeMaker = new CoffeeMaker("Sunbeam", "C12", 12, 8, true);
        return coffeeMaker;
    }

    public ComputerMouse createComputerMouse() {
        int a[] = {0, 0};
        ComputerMouse computerMouse = new ComputerMouse("Razer", "Naga", 960, 540, a);
        return computerMouse;
    }
}

