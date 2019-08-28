package com.example.bankingservice.dao;


import com.example.bankingservice.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDaoJdbcTemplateImpl implements AccountDao {

    JdbcTemplate jdbcTemplate;


    public static final String GET_ACCOUNTS =
    "select * from account where acountNum = ?";

    public static final String INSERT_ACCOUNT =
    "insert into account (accountNum, credit) values (?,?)";

    @Autowired
    public AccountDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Transactional
    @Override
    public Account addAccount(Account account) {
        jdbcTemplate.update(
                INSERT_ACCOUNT,
                account.getAccountNum(),
                account.getCredit());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        account.setId(id);

        return account;
    }
    @Override
    public List<Account> getAllByAccountNum(String accountNum) {
        return jdbcTemplate.query(GET_ACCOUNTS, this::mapRowToAccount, accountNum);
    }

    private Account mapRowToAccount(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setAccountNum(rs.getString("accountNum"));
        account.setCredit(rs.getBigDecimal("credit"));

        return account;
    }
}
