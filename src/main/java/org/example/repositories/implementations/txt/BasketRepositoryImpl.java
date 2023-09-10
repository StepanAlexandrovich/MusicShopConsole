package org.example.repositories.implementations.txt;

import org.example.model.Basket;
import org.example.repositories.BasketRepository;
import org.example.Top;
import org.example.repositories.implementations.txt.universal.TakeObjectsFromTxt;

import java.util.List;

public class BasketRepositoryImpl implements BasketRepository {
    String path = "src/main/resources/baskets.txt";
    TakeObjectsFromTxt<Basket> takeObjectsFromTxt = new TakeObjectsFromTxt<Basket>(path) {
        @Override
        public Basket createObject(String line) {
            return createBasketFromWords(line.split(";"));
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
        return takeObjectsFromTxt.findAll();
    }
    @Override
    public Basket findById(int id) {
        return takeObjectsFromTxt.findById(id);
    }
    @Override
    public List findByFewId(List<Integer> fewId) {
        return takeObjectsFromTxt.findByFewId(fewId);
    }
    @Override
    public List<Basket> findAllByUserId(int id) { return takeObjectsFromTxt.list(2,id); }
}
