package com.example.clientservice.utils.feign;

import com.example.clientservice.model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "banking-service")
public interface BankingClient {

    @RequestMapping(value = "/account/{accountNum}", method = RequestMethod.GET)
    public List<Account> getAllAccountsByAccountNum(@PathVariable String accountNum);

    @RequestMapping(value = "/account/{accountNum}", method = RequestMethod.GET)
    public Account addFundsToAccount(Account account);
}
