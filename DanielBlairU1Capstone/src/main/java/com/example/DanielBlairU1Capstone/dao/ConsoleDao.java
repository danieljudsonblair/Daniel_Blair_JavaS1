package com.example.DanielBlairU1Capstone.dao;

import com.example.DanielBlairU1Capstone.model.Console;

import java.util.List;

public interface ConsoleDao {

    Console add(Console console);

    Console get(int id);

    List<Console> getAll();

    List<Console> getByManufacturer(String manufacturer);

    void update(Console console);

    void delete(int id);
}