package com.example.DanielBlairU1Capstone.dao;

import com.example.DanielBlairU1Capstone.model.Game;
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
public class GameDaoJdbcTemplateImplTest {

    @Autowired
    GameDao gameDao;

    @Before
    public void setUp() throws Exception {
        gameDao.getAll().stream().forEach(g -> gameDao.delete(g.getId()));
    }

    @Test
    public void addGetDeleteGame() {
        Game game = new Game();
        game.setTitle("Title");
        game.setEsrb_rating("Rating");
        game.setDescription("Description");
        game.setPrice(new BigDecimal("19.99"));
        game.setStudio("Studio");
        game.setQuantity(new BigDecimal("100"));

        gameDao.add(game);

        assertEquals(gameDao.get(game.getId()), game);

        gameDao.delete(game.getId());

        assertNull(gameDao.get(game.getId()));
    }

    @Test
    public void getGames() {
        Game game = new Game();
        game.setTitle("Title1");
        game.setEsrb_rating("Rating1");
        game.setDescription("Description1");
        game.setPrice(new BigDecimal("19.99"));
        game.setStudio("Studio1");
        game.setQuantity(new BigDecimal("100"));

        gameDao.add(game);

        game.setTitle("Title2");
        game.setEsrb_rating("Rating2");
        game.setDescription("Description2");
        game.setPrice(new BigDecimal("9.99"));
        game.setStudio("Studio2");
        game.setQuantity(new BigDecimal("99"));

        gameDao.add(game);

        game.setTitle("Title3");
        game.setEsrb_rating("Rating3");
        game.setDescription("Description3");
        game.setPrice(new BigDecimal("1.99"));
        game.setStudio("Studio2");
        game.setQuantity(new BigDecimal("1"));

        gameDao.add(game);

        assertEquals(gameDao.getAll().size(), 3);

        assertEquals(gameDao.getByEsrb("Rating1").size(), 1);

        assertEquals(gameDao.getByStudio("Studio2").size(), 2);

        assertEquals(gameDao.getByTitle("Title1").size(), 1);
    }

    @Test
    public void updateGame() {
        Game game = new Game();
        game.setTitle("Title1");
        game.setEsrb_rating("Rating1");
        game.setDescription("Description1");
        game.setPrice(new BigDecimal("19.99"));
        game.setStudio("Studio1");
        game.setQuantity(new BigDecimal("100"));

        gameDao.add(game);

        game.setTitle("Title");
        game.setEsrb_rating("Rating");
        game.setDescription("Description");
        game.setPrice(new BigDecimal("9.99"));
        game.setStudio("Studio");
        game.setQuantity(new BigDecimal("2"));

        gameDao.update(game);

        assertEquals(gameDao.get(game.getId()), game);
    }
}