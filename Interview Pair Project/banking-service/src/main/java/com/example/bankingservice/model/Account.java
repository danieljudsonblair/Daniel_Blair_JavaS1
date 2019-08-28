package com.example.bankingservice.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {
    private int id;
    private String accountNum;
    private BigDecimal credit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return getId() == account.getId() &&
                getAccountNum().equals(account.getAccountNum()) &&
                getCredit().equals(account.getCredit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountNum(), getCredit());
    }
}
