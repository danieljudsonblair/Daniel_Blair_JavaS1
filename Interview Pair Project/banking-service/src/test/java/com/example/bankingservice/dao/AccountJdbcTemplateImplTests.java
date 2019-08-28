package com.example.bankingservice.dao;

import com.example.bankingservice.model.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AccountJdbcTemplateImplTests {
    @Autowired
    AccountDao dao;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void shouldAddAndGetAccounts() {
        Account account = new Account();
        account.setAccountNum("001");
        account.setCredit(new BigDecimal("100.00"));

        account = dao.addAccount(account);

        Account account1 = new Account();
        account1.setId(1);
        account1.setAccountNum("001");
        account1.setCredit(new BigDecimal("100.00"));

        assertEquals(account1, account);
        assertEquals(dao.getAllByAccountNum("001").size(), 1);
    }
}
