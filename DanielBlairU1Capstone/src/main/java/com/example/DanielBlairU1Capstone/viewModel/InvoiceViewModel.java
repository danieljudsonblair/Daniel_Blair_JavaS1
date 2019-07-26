package com.example.DanielBlairU1Capstone.viewModel;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceViewModel {

    private int id;
    @NotEmpty(message = "You must enter a value for name")
    @Size(min = 1, max = 80)
    private String name;
    @NotEmpty(message = "You must enter a value for street")
    @Size(min = 1, max = 30)
    private String street;
    @NotEmpty(message = "You must enter a value for city")
    @Size(min = 1, max = 30)
    private String city;
    @NotEmpty(message = "You must enter a 2-letter value for state")
    @Size(min = 2, max = 2)
    private String state;
    @NotEmpty(message = "You must enter a 5-digit value for zipcode")
    @Size(min = 5, max = 5)
    private String zipcode;
    @NotEmpty(message = "You must enter a value for item type")
    @Size(min = 1, max = 20)
    private String item_type;
    @Min(1)
    @Max(99999)
    private int item_id;
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999.99", inclusive = true)
    private BigDecimal unit_price;
    @DecimalMin(value = "1.0", inclusive = true)
    @DecimalMax(value = "99999", inclusive = true)
    private BigDecimal quantity;
    @DecimalMin(value = "1", inclusive = true)
    @DecimalMax(value = "999.99", inclusive = true)
    private BigDecimal subtotal;
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999.99", inclusive = true)
    private BigDecimal tax;
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999.99", inclusive = true)
    private BigDecimal processing_fee;
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999.99", inclusive = true)
    private BigDecimal total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getProcessing_fee() {
        return processing_fee;
    }

    public void setProcessing_fee(BigDecimal processing_fee) {
        this.processing_fee = processing_fee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceViewModel that = (InvoiceViewModel) o;
        return getId() == that.getId() &&
                getItem_id() == that.getItem_id() &&
                getName().equals(that.getName()) &&
                getStreet().equals(that.getStreet()) &&
                getCity().equals(that.getCity()) &&
                getState().equals(that.getState()) &&
                getZipcode().equals(that.getZipcode()) &&
                getItem_type().equals(that.getItem_type()) &&
                getUnit_price().equals(that.getUnit_price()) &&
                getQuantity().equals(that.getQuantity()) &&
                getSubtotal().equals(that.getSubtotal()) &&
                getTax().equals(that.getTax()) &&
                getProcessing_fee().equals(that.getProcessing_fee()) &&
                getTotal().equals(that.getTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStreet(), getCity(), getState(), getZipcode(), getItem_type(), getItem_id(), getUnit_price(), getQuantity(), getSubtotal(), getTax(), getProcessing_fee(), getTotal());
    }
}