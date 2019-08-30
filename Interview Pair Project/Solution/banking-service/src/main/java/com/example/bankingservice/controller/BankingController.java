package com.example.bankingservice.controller;

import com.example.bankingservice.model.Account;
import com.example.bankingservice.repository.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class BankingController {

    @Autowired
    AccountDao dao;

    @PostMapping
    public Account addAccount(@RequestBody Account account) {
        return dao.save(account);
    }

    @GetMapping("/{accountnum}")
    public Account getAccount(@PathVariable String accountnum) {
        return dao.findById(accountnum).get();
    }
}
