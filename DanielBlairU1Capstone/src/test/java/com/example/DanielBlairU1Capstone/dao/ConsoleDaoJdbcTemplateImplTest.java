package com.example.DanielBlairU1Capstone.dao;

import com.example.DanielBlairU1Capstone.model.Console;
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
public class ConsoleDaoJdbcTemplateImplTest {

    @Autowired
    ConsoleDao consoleDao;

    @Before
    public void setUp() throws Exception {
        consoleDao.getAll().stream().forEach(c -> consoleDao.delete(c.getId()));
    }

    @Test
    public void addGetDeleteConsole() {
        Console console = new Console();
        console.setModel("Model");
        console.setManufacturer("Manufacturer");
        console.setMemory_amt("A lot");
        console.setProcessor("Processor");
        console.setPrice(new BigDecimal("9.99"));
        console.setQuantity(new BigDecimal("123"));

        consoleDao.add(console);

        assertEquals(consoleDao.get(console.getId()), console);

        consoleDao.delete(console.getId());

        assertNull(consoleDao.get(console.getId()));
    }

    @Test
    public void getConsoles() {
        Console console = new Console();
        console.setModel("Model");
        console.setManufacturer("Manufacturer");
        console.setMemory_amt("A lot");
        console.setProcessor("Processor");
        console.setPrice(new BigDecimal("9.99"));
        console.setQuantity(new BigDecimal("123"));

        consoleDao.add(console);

        console.setModel("Model2");
        console.setManufacturer("Manufacturer2");
        console.setMemory_amt("A little");
        console.setProcessor("Processor2");
        console.setPrice(new BigDecimal("19.99"));
        console.setQuantity(new BigDecimal("12"));

        consoleDao.add(console);

        console.setModel("Model3");
        console.setManufacturer("Manufacturer");
        console.setMemory_amt("A lot");
        console.setProcessor("Processor");
        console.setPrice(new BigDecimal("9.99"));
        console.setQuantity(new BigDecimal("123"));

        consoleDao.add(console);

        assertEquals(consoleDao.getAll().size(), 3);

        assertEquals(consoleDao.getByManufacturer("Manufacturer").size(), 2);
    }

    @Test
    public void updateConsole() {
        Console console = new Console();
        console.setModel("Model");
        console.setManufacturer("Manufacturer");
        console.setMemory_amt("A lot");
        console.setProcessor("Processor");
        console.setPrice(new BigDecimal("9.99"));
        console.setQuantity(new BigDecimal("123"));

        consoleDao.add(console);

        console.setModel("Model2");
        console.setManufacturer("Manufacturer2");
        console.setMemory_amt("A little");
        console.setProcessor("Processor2");
        console.setPrice(new BigDecimal("19.99"));
        console.setQuantity(new BigDecimal("12"));

        consoleDao.update(console);

        assertEquals(consoleDao.get(console.getId()), console);
    }
}