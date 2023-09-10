package org.example.repositories.implementations.jdbc;

import org.example.Helper;
import org.example.model.CompositionBasketRelation;
import org.example.model.Genre;
import org.example.repositories.CompositionBasketRelationRepository;
import org.example.repositories.implementations.jdbc.universal.PutInDeleteFromDataBase;
import org.example.repositories.implementations.jdbc.universal.TakeFromDataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CompositionBasketRelationRepositoryJdbcImpl implements CompositionBasketRelationRepository {
    private final String tableName = "composition_basket_relations";
    private TakeFromDataBase<CompositionBasketRelation> takeFromDataBase = new TakeFromDataBase<>(tableName) {
        @Override
        public CompositionBasketRelation createObject(ResultSet resultSet) {
            try {
                int id = resultSet.getInt("id");
                int countOfCompositions = resultSet.getInt("count_of_compositions");
                int compositionId= resultSet.getInt("composition_id");
                int basketId = resultSet.getInt("basket_id");

                return new CompositionBasketRelation(id,countOfCompositions,compositionId,basketId);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    };
    private PutInDeleteFromDataBase<Genre> putInDeleteFromDataBase = new PutInDeleteFromDataBase<>(tableName);

    // find ---------------
    @Override
    public List<CompositionBasketRelation> findAllByBasketId(int id) {
        return takeFromDataBase.list("basket_id",id);
    }

    @Override
    public List<CompositionBasketRelation> findAll() {
        return takeFromDataBase.findAll();
    }

    @Override
    public List findByFewId(List<Integer> fewId) {
        // избавиться
        return null;
    }

    @Override
    public CompositionBasketRelation findById(int id) {
        return takeFromDataBase.findById(id);
    }


    // add del
    private boolean addCompositionBasketRelation(int compositionId, int basketId, int countOfCompositions){
        String descriptionValues = Helper.commas("count_of_compositions","composition_id","basket_id");
        String stringValues =  Helper.commas(
                Integer.toString(countOfCompositions),
                Integer.toString(compositionId),
                Integer.toString(basketId)
        );

        return putInDeleteFromDataBase.add(descriptionValues,stringValues);
    }
    @Override
    public CompositionBasketRelation addCompositionToBasket(int compositionId, int basketId) {
        String condition = "composition_id = "+compositionId + " and " + "basket_id = "+basketId;

        CompositionBasketRelation compositionBasketRelation = takeFromDataBase.findByCondition(condition);

        if(compositionBasketRelation == null){
            addCompositionBasketRelation(compositionId,basketId,1);
        }else{
            int count = compositionBasketRelation.getCountOfCompositions();
            putInDeleteFromDataBase.delete(condition);
            addCompositionBasketRelation(compositionId,basketId,count + 1);
        }

        return takeFromDataBase.findByCondition(condition);
    }

    @Override
    public boolean deleteCompositionFromBasket(int compositionId, int basketId) {
        String condition = "composition_id = "+compositionId + " and " + "basket_id = "+basketId;
        CompositionBasketRelation compositionBasketRelation = takeFromDataBase.findByCondition(condition);

        if(compositionBasketRelation != null){
            int count = compositionBasketRelation.getCountOfCompositions();
            putInDeleteFromDataBase.delete(condition);

            if(takeFromDataBase.findByCondition(condition)==null){
                if(count > 1){
                    addCompositionBasketRelation(compositionId,basketId,count - 1);
                    if(takeFromDataBase.findByCondition(condition)!=null){ return true; }
                }else{
                    return true;
                }
            }

        }else{
            System.out.println("такой композиции нету");
            return false;
        }

        System.out.println("Что то пошло не так");
        return false;
    }

}
