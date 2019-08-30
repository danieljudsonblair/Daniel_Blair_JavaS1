package com.example.clientservice.viewmodel;

import com.example.clientservice.model.Account;

import java.math.BigDecimal;
import java.util.Objects;

public class AccountView extends Account {
    private BigDecimal beginningBalance;
    private BigDecimal endingBalance;

    public BigDecimal getBeginningBalance() {
        return beginningBalance;
    }

    public void setBeginningBalance(BigDecimal beginningBalance) {
        this.beginningBalance = beginningBalance;
    }

    public BigDecimal getEndingBalance() {
        return endingBalance;
    }

    public void setEndingBalance(BigDecimal endingBalance) {
        this.endingBalance = endingBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AccountView that = (AccountView) o;
        return getBeginningBalance().equals(that.getBeginningBalance()) &&
                getEndingBalance().equals(that.getEndingBalance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBeginningBalance(), getEndingBalance());
    }
}
