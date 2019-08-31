package com.example.clientservice.service;

import com.example.clientservice.model.Account;
import com.example.clientservice.utils.feign.BankingClient;
import com.example.clientservice.viewmodel.AccountView;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

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
        account.setAccountNum("001");
        account.setCredit(new BigDecimal("200.00"));

        Account account1 = new Account();
        account1.setAccountNum("001");
        account1.setCredit(new BigDecimal("100.00"));

        Account account2 = new Account();
        account2.setAccountNum("002");
        account2.setCredit(new BigDecimal("100.00"));

        doThrow(new NotFoundException()).when(client).getAccount("002");
        doReturn(account2).when(client).addToAccount(account2);
        doReturn(account).when(client).addToAccount(account);
        doReturn(account1).when(client).getAccount("001");
    }

    @Test
    public void shouldGetBalanceByAccountNum() {
        Account account = new Account();
        account.setAccountNum("001");
        account.setCredit(new BigDecimal("100.00"));

        AccountView av = new AccountView();
        av.setAccountNum("001");
        av.setCredit(new BigDecimal("100.00"));
        av.setBeginningBalance(new BigDecimal("100.00"));
        av.setEndingBalance(new BigDecimal("200.00"));



        AccountView fromService = service.saveAccount(account);
        assertEquals(fromService, av);
    }

    @Test
    public void shouldCatchNotFoundExceptionAndSaveAccount() {
        Account account = new Account();
        account.setAccountNum("002");
        account.setCredit(new BigDecimal("100.00"));

        AccountView av = new AccountView();
        av.setAccountNum("002");
        av.setCredit(new BigDecimal("100.00"));
        av.setBeginningBalance(new BigDecimal("0.00"));
        av.setEndingBalance(new BigDecimal("100.00"));

        AccountView fromService = service.saveAccount(account);
        assertEquals(fromService, av);
    }

    class NotFoundException extends RuntimeException {

        public NotFoundException() {
        }

        public NotFoundException(String message) {
            super(message);
        }
    }
}
