package com.example.bankingservice.controller;

import com.example.bankingservice.dao.AccountDao;
import com.example.bankingservice.model.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;



@RunWith(SpringRunner.class)
@WebMvcTest(BankingController.class)
public class BankingControllerTests {

    @MockBean
    AccountDao dao;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();
    private String accountJson;

    @Before
    public void setUp() throws Exception {

    }
}
