package com.example.DanielBlairU1Capstone.dao;

import com.example.DanielBlairU1Capstone.model.Game;

import java.util.List;

public interface GameDao {

    Game add(Game game);

    Game get(int id);

    List<Game> getAll();

    List<Game> getByStudio(String studio);

    List<Game> getByEsrb(String esrb);

    List<Game> getByTitle(String title);

    void update(Game game);

    void delete(int id);
}