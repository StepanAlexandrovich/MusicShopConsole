package org.example.services.implementations;

import org.example.model.Basket;
import org.example.repositories.BasketRepository;
import org.example.repositories.implementations.BasketRepositoryImpl;
import org.example.services.BasketService;
import org.example.repositories.implementations.OneToManyImpl;

import java.util.List;

public class BasketServiceImpl implements BasketService {
    private BasketRepository basketRepository = new BasketRepositoryImpl();
    private OneToManyImpl<BasketRepository> oneToMany= new OneToManyImpl<>(basketRepository,"src/main/resources/baskets.txt");

    @Override
    public Basket getById(int id) {
        return basketRepository.findById(id);
    }
    @Override
    public List<Basket> getAll() {
        return basketRepository.findAll();
    }
    @Override
    public List<Basket> getAllByUserId(int id) { return oneToMany.setFirstLast(0,2).list(id); }
}
