package com.example.DanielBlairU1Capstone.model;

import java.util.Objects;

public class Tshirt extends Item {

    private String size;
    private String color;
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
        Tshirt tshirt = (Tshirt) o;
        return getSize().equals(tshirt.getSize()) &&
                getColor().equals(tshirt.getColor()) &&
                getDescription().equals(tshirt.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSize(), getColor(), getDescription());
    }
}