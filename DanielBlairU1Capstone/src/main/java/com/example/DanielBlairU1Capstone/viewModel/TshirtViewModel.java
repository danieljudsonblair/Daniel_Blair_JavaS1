package com.example.DanielBlairU1Capstone.viewModel;

import javax.validation.constraints.*;
import java.util.Objects;

public class TshirtViewModel extends ItemViewModel {

    @NotNull(message = "Missing property: size")
    @NotEmpty(message = "Please supply a value for Size")
    private String size;
    @NotNull(message = "Missing property: color")
    @NotEmpty(message = "Please supply a value for Color")
    private String color;
    @NotNull(message = "Missing property: description")
    @NotEmpty(message = "Please supply a value for Description")
    private String description;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TshirtViewModel that = (TshirtViewModel) o;
        return getSize().equals(that.getSize()) &&
                getColor().equals(that.getColor()) &&
                getDescription().equals(that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSize(), getColor(), getDescription());
    }
}