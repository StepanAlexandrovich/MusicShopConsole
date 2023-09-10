package org.example.services.implementations;

import org.example.model.CompositionBasketRelation;
import org.example.repositories.CompositionBasketRelationRepository;
import org.example.repositories.implementations.jdbc.CompositionBasketRelationRepositoryJdbcImpl;
//import org.example.repositories.implementations.txt.BasketCompositionRelationRepositoryImpl;
import org.example.services.CompositionBasketRelationService;

import java.util.List;

public class CompositionBasketRelationServiceImpl implements CompositionBasketRelationService {
    //private BasketCompositionRelationRepository basketCompositionRelationRepository = new BasketCompositionRelationRepositoryImpl();
    private CompositionBasketRelationRepository compositionBasketRelationRepository = new CompositionBasketRelationRepositoryJdbcImpl();
    @Override
    public CompositionBasketRelation getById(int id) {
        return compositionBasketRelationRepository.findById(id);
    }
    @Override
    public List<CompositionBasketRelation> getAllByBasketId(int id) {
        return compositionBasketRelationRepository.findAllByBasketId(id);
    }
    @Override
    public CompositionBasketRelation addCompositionInBasket(int compositionId,int basketId) {
        return compositionBasketRelationRepository.addCompositionToBasket(compositionId,basketId);
    }

    @Override
    public boolean deleteCompositionFromBasket(int compositionId, int basketId) {
        return compositionBasketRelationRepository.deleteCompositionFromBasket(compositionId,basketId);
    }

}
