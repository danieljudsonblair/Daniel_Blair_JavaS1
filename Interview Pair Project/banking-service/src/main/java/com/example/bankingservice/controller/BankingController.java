package com.example.bankingservice.controller;

import com.example.bankingservice.dao.AccountDao;
import com.example.bankingservice.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class BankingController {

    @Autowired
    AccountDao dao;

    @GetMapping("/{accountNum}")
    public List<Account> getAccountsByAccountNum(@PathVariable String accountNum) {
        return null;
    }
}
