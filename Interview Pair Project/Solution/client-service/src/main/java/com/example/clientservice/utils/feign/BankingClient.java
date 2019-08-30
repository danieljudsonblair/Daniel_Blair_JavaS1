package com.example.clientservice.utils.feign;

import com.example.clientservice.model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "banking-service")
public interface BankingClient {
    @PostMapping("/accounts")
    Account addToAccount(Account account);

    @GetMapping("/accounts/{accountnum}")
    Account getAccount(@PathVariable String accountnum);
}
