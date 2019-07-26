package com.example.DanielBlairU1Capstone.viewModel;

import javax.validation.constraints.*;
import java.util.Objects;

public class ConsoleViewModel extends ItemViewModel {

    @NotNull(message = "Missing property: model")
    @NotEmpty(message = "Please supply a value for Model")
    private String model;
    @NotNull(message = "Missing property: manufacturer")
    @NotEmpty(message = "Please supply a value for Manufacturer")
    private String manufacturer;
    @NotNull(message = "Missing property: memory_amount")
    @NotEmpty(message = "Please supply a value for Memory Amt")
    private String memory_amount;
    @NotNull(message = "Missing property: processor")
    @NotEmpty(message = "Please supply a value for Processor")
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

    public String getMemory_amount() {
        return memory_amount;
    }

    public void setMemory_amount(String memory_amount) {
        this.memory_amount = memory_amount;
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
        ConsoleViewModel that = (ConsoleViewModel) o;
        return getModel().equals(that.getModel()) &&
                getManufacturer().equals(that.getManufacturer()) &&
                getMemory_amount().equals(that.getMemory_amount()) &&
                getProcessor().equals(that.getProcessor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getModel(), getManufacturer(), getMemory_amount(), getProcessor());
    }
}