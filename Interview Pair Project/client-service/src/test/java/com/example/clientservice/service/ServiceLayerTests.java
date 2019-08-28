package com.example.clientservice.service;

import com.example.clientservice.model.Account;
import com.example.clientservice.utils.feign.BankingClient;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTests {

    BankingClient client;

    ServiceLayer service;

    @Before
    public void setUp() {

        setUpBankingClientDaoMock();
        service = new ServiceLayer(client);
    }

    private void setUpBankingClientDaoMock() {
        client = mock(BankingClient.class);

        Account account = new Account();
        account.setId(1);
        account.setAccountNum("001");
        account.setCredit(new BigDecimal("100.00"));

        List<Account> accountList = new ArrayList<>();

        accountList.add(account);

        Account account1 = new Account();

        account1.setAccountNum("001");
        account1.setCredit(new BigDecimal("100.00"));


        doReturn(account).when(client).addFundsToAccount(account1);
        doReturn(accountList).when(client).getAllAccountsByAccountNum("001");
    }
    @Test
    public void shouldGetBalanceByAccountNum() {
        Account account = new Account();
        account.setId(1);
        account.setAccountNum("001");
        account.setCredit(new BigDecimal("100.00"));

        List<Account> accountList = new ArrayList<>();

        accountList.add(account);

        BigDecimal fromService = service.getBalanceByAccount(account.getAccountNum());
        assertEquals(fromService, account.getCredit());
    }

    @Test
    public void shouldReturnNewBalanceWhenAddingFunds() {
        BigDecimal balance = new BigDecimal("200.00");

        Account account = new Account();
        account.setAccountNum("001");
        account.setCredit(new BigDecimal("100.00"));

        BigDecimal fromService = service.addFunds(account);
        assertEquals(fromService, balance);
    }

}
