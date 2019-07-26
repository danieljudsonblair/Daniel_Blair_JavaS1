package com.example.DanielBlairU1Capstone.dao;

import com.example.DanielBlairU1Capstone.model.Tshirt;

import java.util.List;

public interface TshirtDao {

    Tshirt add(Tshirt tshirt);

    Tshirt get(int id);

    List<Tshirt> getAll();

    List<Tshirt> getByColor(String color);

    List<Tshirt> getBySize(String size);

    void update(Tshirt tshirt);

    void delete(int id);
}