package org.example.repositories.implementations;

import org.example.Helper;
import org.example.model.BasketComposition;
import org.example.model.ObjectWithId;
import org.example.repositories.BasketCompositionRepository;
import org.example.Top;

import java.util.List;

public class BasketCompositionRepositoryImpl implements BasketCompositionRepository {
    private String path = "src/main/resources/basket_compositions.txt";
    private CreateObjectFromString<BasketComposition> createObjectFromString = new CreateObjectFromString(path) {
        @Override
        public ObjectWithId createObject(String line) {
            String[] words = line.split(";");
            BasketComposition basketComposition = createBasketCompositionFromWords(words);
            basketComposition.setComposition(Top.compositionService.getById( basketComposition.getCompositionId() ));
            return basketComposition;
        }
        private BasketComposition createBasketCompositionFromWords(String[] words){
            int [] values = Helper.arrayStringToInt(words);
            return new BasketComposition(values[0],values[1],values[2],values[3]);
        }
    };

    @Override
    public List<BasketComposition> findAll() {
        return createObjectFromString.findAll();
    }

    @Override
    public BasketComposition findById(int id) {
        return createObjectFromString.findById(id);
    }

    @Override
    public List findByFewId(List<Integer> fewId) {
        return createObjectFromString.findByFewId(fewId);
    }

}
