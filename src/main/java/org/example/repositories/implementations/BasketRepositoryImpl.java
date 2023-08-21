package org.example.repositories.implementations;

import org.example.model.Basket;
import org.example.repositories.BasketRepository;
import org.example.Top;

import java.util.List;

public class BasketRepositoryImpl implements BasketRepository {
    String path = "src/main/resources/baskets.txt";
    CreateObjectFromString<Basket> createObjectFromString = new CreateObjectFromString<Basket>(path) {
        @Override
        public Basket createObject(String line) {
            Basket basket = createBasketFromWords(line.split(";"));
            basket.setCompositions(Top.basketCompositionService.getAllByBasketId(basket.getId()));
            return basket;
        }
        private Basket createBasketFromWords(String[] words){
            boolean b = false;
            switch (words[1]){
                case "true":  b = true; break;
                case "false": b = false; break;
            }
            return new Basket(Integer.parseInt(words[0]),b,Integer.parseInt(words[2]));
        }
    };

    @Override
    public List<Basket> findAll() {
        return createObjectFromString.findAll();
    }
    @Override
    public Basket findById(int id) {
        return createObjectFromString.findById(id);
    }
    @Override
    public List findByFewId(List<Integer> fewId) {
        return createObjectFromString.findByFewId(fewId);
    }
}
