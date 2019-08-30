package com.example.bankingservice.repository;

import com.example.bankingservice.model.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AccountDaoTest {

    @Autowired
    AccountDao dao;

    @Test
    public void shouldSaveAccount() {
        Account account = new Account();
        account.setAccountNum("001");
        account.setCredit(new BigDecimal("100.00"));
        account = dao.save(account);

        assertEquals(account, dao.findById("001").get());
    }
}
