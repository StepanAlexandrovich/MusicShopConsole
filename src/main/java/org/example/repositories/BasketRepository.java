package org.example.repositories;

import org.example.model.Basket;
import org.example.repositories.functional.FindAll;
import org.example.repositories.functional.FindByFewId;
import org.example.repositories.functional.FindById;

import java.util.List;

public interface BasketRepository extends FindAll<Basket>, FindById<Basket>, FindByFewId<Basket> {
    List<Basket> findAllByUserId(int id);
}