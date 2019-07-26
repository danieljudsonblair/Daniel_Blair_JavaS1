package com.example.DanielBlairU1Capstone.viewModel;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class PurchaseViewModel {

    @NotNull(message = "Missing property: name")
    @NotEmpty(message = "You must enter a name")
    @Size(min = 1, max = 80)
    private String name;
    @NotNull(message = "Missing property: street")
    @NotEmpty(message = "You must enter a street")
    @Size(min = 1, max = 30)
    private String street;
    @NotNull(message = "Missing property: city")
    @NotEmpty(message = "You must enter a city")
    @Size(min = 1, max = 30)
    private String city;
    @NotNull(message = "Missing property: state")
    @NotEmpty(message = "You must enter a street")
    @Size(min = 1, max = 30)
    private String state;
    @NotNull(message = "Missing property: zipcode")
    @NotEmpty(message = "You must enter a 5-digit value for zipcode")
    @Size(min = 5, max = 5)
    private String zipcode;
    @NotNull(message = "Missing property: item_type")
    @NotEmpty(message = "You must enter a value for item type")
    @Size(min = 1, max = 20)
    private String item_type;
    @Min(1)
    @Max(99999999)
    private int item_id;
    @NotNull(message = "Missing property: quantity")
    @DecimalMin(value = "1", inclusive = true)
    @DecimalMax(value = "999.99", inclusive = true)
    private BigDecimal quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
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
        PurchaseViewModel that = (PurchaseViewModel) o;
        return getItem_id() == that.getItem_id() &&
                getName().equals(that.getName()) &&
                getStreet().equals(that.getStreet()) &&
                getCity().equals(that.getCity()) &&
                getState().equals(that.getState()) &&
                getZipcode().equals(that.getZipcode()) &&
                getItem_type().equals(that.getItem_type()) &&
                getQuantity().equals(that.getQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getStreet(), getCity(), getState(), getZipcode(), getItem_type(), getItem_id(), getQuantity());
    }
}