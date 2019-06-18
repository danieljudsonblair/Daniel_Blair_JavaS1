package com.company;

import com.opencsv.bean.CsvBindByName;

public class Computer {

    @CsvBindByName(column = "Brand")
    private String brand;
    @CsvBindByName(column = "Model")
    private String model;
    @CsvBindByName(column = "CPU")
    private String cpu;
    @CsvBindByName(column = "RAM")
    private String ram;
    @CsvBindByName(column = "StorageSize")
    private String storageSize;

    public Computer(String brand, String model, String cpu, String ram, String storageSize) {
        this.brand = brand;
        this.model = model;
        this.cpu = cpu;
        this.ram = ram;
        this.storageSize = storageSize;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getCpu() {
        return cpu;
    }

    public String getRam() {
        return ram;
    }

    public String getStorageSize() {
        return storageSize;
    }
}