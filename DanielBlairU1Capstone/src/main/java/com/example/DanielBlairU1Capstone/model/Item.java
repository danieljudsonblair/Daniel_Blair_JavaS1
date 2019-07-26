package com.example.DanielBlairU1Capstone.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Item {

    private int id;
    private BigDecimal price;
    private BigDecimal quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return getId() == item.getId() &&
                getPrice().equals(item.getPrice()) &&
                getQuantity().equals(item.getQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrice(), getQuantity());
    }
}
