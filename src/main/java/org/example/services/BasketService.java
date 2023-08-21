package org.example.services;

import org.example.model.Basket;

import java.util.List;

public interface BasketService {
    Basket getById(int id);
    List<Basket> getAll();

    List<Basket> getAllByUserId(int userId);
}
