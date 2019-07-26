package com.example.DanielBlairU1Capstone.dao;

import com.example.DanielBlairU1Capstone.model.Tshirt;
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
public class TshirtDaoJdbcTemplateImplTest {

    @Autowired
    TshirtDao tshirtDao;

    @Before
    public void setUp() throws Exception {
        tshirtDao.getAll().stream().forEach(t -> tshirtDao.delete(t.getId()));
    }

    @Test
    public void addGetDeleteTshirt() {
        Tshirt tshirt = new Tshirt();
        tshirt.setSize("Small");
        tshirt.setColor("Black");
        tshirt.setDescription("Description");
        tshirt.setPrice(new BigDecimal("19.99"));
        tshirt.setQuantity(new BigDecimal("100"));

        tshirtDao.add(tshirt);

        assertEquals(tshirtDao.get(tshirt.getId()), tshirt);

        tshirtDao.delete(tshirt.getId());

        assertNull(tshirtDao.get(tshirt.getId()));
    }

    @Test
    public void getTshirts() {
        Tshirt tshirt = new Tshirt();
        tshirt.setSize("Small");
        tshirt.setColor("Black");
        tshirt.setDescription("Description");
        tshirt.setPrice(new BigDecimal("19.99"));
        tshirt.setQuantity(new BigDecimal("100"));

        tshirtDao.add(tshirt);

        tshirt.setSize("Medium");
        tshirt.setColor("Black");
        tshirt.setDescription("Description2");
        tshirt.setPrice(new BigDecimal("18.99"));
        tshirt.setQuantity(new BigDecimal("95"));

        tshirtDao.add(tshirt);

        tshirt.setSize("Large");
        tshirt.setColor("White");
        tshirt.setDescription("Description3");
        tshirt.setPrice(new BigDecimal("17.99"));
        tshirt.setQuantity(new BigDecimal("90"));

        tshirtDao.add(tshirt);

        assertEquals(tshirtDao.getAll().size(), 3);

        assertEquals(tshirtDao.getByColor("Black").size(), 2);

        assertEquals(tshirtDao.getBySize("Small").size(), 1);
    }

    @Test
    public void updateTshirt() {
        Tshirt tshirt = new Tshirt();
        tshirt.setSize("Small");
        tshirt.setColor("Black");
        tshirt.setDescription("Description");
        tshirt.setPrice(new BigDecimal("19.99"));
        tshirt.setQuantity(new BigDecimal("100"));

        tshirtDao.add(tshirt);

        tshirt.setSize("Smaller");
        tshirt.setColor("Blue");
        tshirt.setDescription("Updated Description");
        tshirt.setPrice(new BigDecimal("15.99"));
        tshirt.setQuantity(new BigDecimal("50"));

        tshirtDao.update(tshirt);

        assertEquals(tshirtDao.get(tshirt.getId()), tshirt);
    }
}