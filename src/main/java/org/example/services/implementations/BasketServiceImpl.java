package org.example.services.implementations;

import org.example.model.Basket;
import org.example.repositories.BasketRepository;
import org.example.repositories.implementations.jdbc.BasketRepositoryJdbcImpl;
//import org.example.repositories.implementations.txt.BasketRepositoryImpl;
import org.example.services.BasketService;

import java.util.List;

public class BasketServiceImpl implements BasketService {
    //private BasketRepository basketRepository = new BasketRepositoryImpl();
    private BasketRepository basketRepository = new BasketRepositoryJdbcImpl();
    @Override
    public Basket getById(int id) {
        return basketRepository.findById(id);
    }
    @Override
    public List<Basket> getAll() {
        return basketRepository.findAll();
    }
    @Override
    public List<Basket> getAllByUserId(int id) { return basketRepository.findAllByUserId(id); }
}
