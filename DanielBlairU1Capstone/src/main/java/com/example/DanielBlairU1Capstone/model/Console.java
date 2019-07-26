package com.example.DanielBlairU1Capstone.model;

import java.util.Objects;

public class Console extends Item {

    private String model;
    private String manufacturer;
    private String memory_amt;
    private String processor;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemory_amt() {
        return memory_amt;
    }

    public void setMemory_amt(String memory_amt) {
        this.memory_amt = memory_amt;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Console console = (Console) o;
        return getModel().equals(console.getModel()) &&
                getManufacturer().equals(console.getManufacturer()) &&
                getMemory_amt().equals(console.getMemory_amt()) &&
                getProcessor().equals(console.getProcessor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getModel(), getManufacturer(), getMemory_amt(), getProcessor());
    }
}