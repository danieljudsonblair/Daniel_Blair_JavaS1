package com.example.bankingservice.controller;

import com.example.bankingservice.dao.AccountDao;
import com.example.bankingservice.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class BankingController {

    @Autowired
    AccountDao dao;

    @PostMapping
    public Account addAccount(@RequestBody Account account) {
        return dao.addAccount(account);
    }

    @GetMapping("/{accountNum}")
    public List<Account> getAccountsByAccountNum(@PathVariable String accountNum) {
        return dao.getAllByAccountNum(accountNum);
    }
}
