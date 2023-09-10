package org.example.repositories.implementations.txt;

import org.example.Helper;
import org.example.application.ReadText;
import org.example.application.WriteText;
import org.example.model.CompositionBasketRelation;
import org.example.model.ObjectWithId;
import org.example.repositories.CompositionBasketRelationRepository;
import org.example.Top;
import org.example.repositories.implementations.txt.universal.TakeObjectsFromTxt;

import java.util.List;

public class CompositionBasketRelationRepositoryImpl implements CompositionBasketRelationRepository {
    private String path = "src/main/resources/basket_compositions.txt";
    private WriteText writeText = new WriteText();
    ReadText readText = new ReadText();
    private TakeObjectsFromTxt<CompositionBasketRelation> takeObjectsFromTxt = new TakeObjectsFromTxt(path) {
        @Override
        public ObjectWithId createObject(String line) {
            String[] words = line.split(";");
            return createBasketCompositionFromWords(words);
        }
        private CompositionBasketRelation createBasketCompositionFromWords(String[] words){
            int [] values = Helper.arrayStringToInt(words);
            return new CompositionBasketRelation(values[0],values[1],values[2],values[3]);
        }
    };

    @Override
    public List<CompositionBasketRelation> findAll() {
        return takeObjectsFromTxt.findAll();
    }

    @Override
    public CompositionBasketRelation findById(int id) {
        return takeObjectsFromTxt.findById(id);
    }

    @Override
    public List findByFewId(List<Integer> fewId) {
        return takeObjectsFromTxt.findByFewId(fewId);
    }

    @Override
    public CompositionBasketRelation addCompositionToBasket(int compositionId, int basketId) {
        int id = readText.lastIndex(path) + 1;
        int count = 1;

        String text = "" + id + ";" + count + ";" + compositionId + ";" + basketId;
        writeText.write(path,text);

        //Top.basketService.getById(basketId).

        return findById(id);
    }

    @Override
    public List<CompositionBasketRelation> findAllByBasketId(int id) {
        return takeObjectsFromTxt.list(3,id);
    }

    @Override
    public boolean deleteCompositionFromBasket(int compositionId, int basketId) {
        System.out.println("empty");
        return false;
    }
}
