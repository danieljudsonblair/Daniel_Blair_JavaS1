package com.example.clientservice.service;

import com.example.clientservice.model.Account;
import com.example.clientservice.utils.feign.BankingClient;
import com.example.clientservice.viewmodel.AccountView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ServiceLayer {

    BankingClient client;

    @Autowired
    public ServiceLayer(BankingClient client) {
        this.client = client;
    }

    public AccountView saveAccount(Account account) {
        boolean newAcct = false;
        AccountView av = new AccountView();
        av.setAccountNum(account.getAccountNum());
        av.setCredit(account.getCredit());

        try {
            client.getAccount(account.getAccountNum()).getCredit();
        } catch (Exception e) {
            account = client.addToAccount(account);
            newAcct = true;
            av.setBeginningBalance(new BigDecimal("0.00"));
            av.setEndingBalance(account.getCredit());
        }
        if (!newAcct) {
            account.setCredit(client.getAccount(account.getAccountNum()).getCredit().add(account.getCredit()));
            av.setBeginningBalance(client.getAccount(account.getAccountNum()).getCredit());
            client.addToAccount(account);
            av.setEndingBalance(client.getAccount(account.getAccountNum()).getCredit());
        }

        return av;
    }
}
