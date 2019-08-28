package com.example.clientservice.service;

import com.example.clientservice.model.Account;
import com.example.clientservice.utils.feign.BankingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ServiceLayer {

    private BankingClient bankingClient;


    @Autowired
    public ServiceLayer(BankingClient bankingClient) {
        this.bankingClient = bankingClient;

    }

    public BigDecimal getBalanceByAccount(String accountNum) {
        BigDecimal balance = new BigDecimal("0");
        List<Account> search = bankingClient.getAllAccountsByAccountNum(accountNum);

        for (Account account : search) {
            balance = balance.add(account.getCredit());
        }

        return balance;
    }

    public BigDecimal addFunds(Account account) {
        BigDecimal pre = getBalanceByAccount(account.getAccountNum());
        Account account1 = bankingClient.addFundsToAccount(account);
        BigDecimal post = account1.getCredit();
        return pre.add(post);
    }
}