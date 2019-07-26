package com.example.DanielBlairU1Capstone.dao;

import com.example.DanielBlairU1Capstone.model.SalesTaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SalesTaxRateDaoJdbcTemplateImpl implements SalesTaxRateDao {

    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_SALES_TAX_BY_STATE_SQL =
            "select * from sales_tax_rate rate where state = ?";

    private static final String SELECT_ALL_STATES_SQL =
            "select state from sales_tax_rate";

    @Autowired
    public SalesTaxRateDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public SalesTaxRate get(String state) {
        try {
            return jdbcTemplate.queryForObject(SELECT_SALES_TAX_BY_STATE_SQL, this::mapRowToSalesTaxRate, state);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private SalesTaxRate mapRowToSalesTaxRate(ResultSet rs, int rowNum) throws SQLException {
        SalesTaxRate str = new SalesTaxRate();
        str.setState(rs.getString("state"));
        str.setRate(rs.getBigDecimal("rate"));

        return str;
    }
}