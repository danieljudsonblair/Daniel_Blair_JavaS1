package com.example.clientservice.controller;

import com.example.clientservice.model.Account;
import com.example.clientservice.service.ServiceLayer;
import com.example.clientservice.viewmodel.AccountView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    ServiceLayer service;

    @PostMapping("/{accountnum}")
    public AccountView saveAccount(@PathVariable String accountnum, @RequestBody Account account) {
        account.setAccountNum(accountnum);
        return service.saveAccount(account);
    }
}
