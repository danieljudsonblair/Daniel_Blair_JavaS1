package com.example.DanielBlairU1Capstone.dao;

import com.example.DanielBlairU1Capstone.model.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoJdbcTemplateImplTest {

    @Autowired
    InvoiceDao invoiceDao;

    @Before
    public void setUp() throws Exception {
        invoiceDao.getAll().stream().forEach(i -> invoiceDao.delete(i.getId()));
    }

    @Test
    public void addGetDeleteInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("Name");
        invoice.setStreet("Street");
        invoice.setCity("City");
        invoice.setState("NC");
        invoice.setZipcode("28277");
        invoice.setItem_type("Item type");
        invoice.setItem_id(123456);
        invoice.setPrice(new BigDecimal("100.00"));
        invoice.setQuantity(new BigDecimal("12"));
        invoice.setSubtotal(new BigDecimal("100.00"));
        invoice.setTax(new BigDecimal(".05"));
        invoice.setProcessing_fee(new BigDecimal("14.95"));
        invoice.setTotal(new BigDecimal("114.95"));

        invoiceDao.add(invoice);

        assertEquals(invoiceDao.get(invoice.getId()), invoice);

        invoiceDao.delete(invoice.getId());

        assertNull(invoiceDao.get(invoice.getId()));
    }

    @Test
    public void getAll() {
        Invoice invoice = new Invoice();
        invoice.setName("Name");
        invoice.setStreet("Street");
        invoice.setCity("City");
        invoice.setState("NC");
        invoice.setZipcode("28277");
        invoice.setItem_type("Item type");
        invoice.setItem_id(123456);
        invoice.setPrice(new BigDecimal("100.00"));
        invoice.setQuantity(new BigDecimal("12"));
        invoice.setSubtotal(new BigDecimal("100.00"));
        invoice.setTax(new BigDecimal(".05"));
        invoice.setProcessing_fee(new BigDecimal("14.95"));
        invoice.setTotal(new BigDecimal("114.95"));

        invoiceDao.add(invoice);

        invoice.setName("Name2");
        invoice.setStreet("Street2");
        invoice.setCity("City2");
        invoice.setState("SC");
        invoice.setZipcode("28270");
        invoice.setItem_type("Item type2");
        invoice.setItem_id(123457);
        invoice.setPrice(new BigDecimal("99.99"));
        invoice.setQuantity(new BigDecimal("11"));
        invoice.setSubtotal(new BigDecimal("99.99"));
        invoice.setTax(new BigDecimal(".04"));
        invoice.setProcessing_fee(new BigDecimal("12.95"));
        invoice.setTotal(new BigDecimal("112.94"));

        invoiceDao.add(invoice);

        assertEquals(invoiceDao.getAll().size(), 2);
    }
}