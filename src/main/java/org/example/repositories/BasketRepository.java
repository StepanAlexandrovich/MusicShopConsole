package org.example.repositories;

import org.example.model.Basket;
public interface BasketRepository extends FindAll<Basket>,FindById<Basket>,FindByFewId<Basket>{}
