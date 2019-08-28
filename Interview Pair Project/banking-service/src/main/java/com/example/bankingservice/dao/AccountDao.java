package com.example.bankingservice.dao;


import com.example.bankingservice.model.Account;

import java.util.List;

public interface AccountDao {

    public List<Account> getAllByAccountNum(String accountNum);

    public Account addAccount(Account account);
}
