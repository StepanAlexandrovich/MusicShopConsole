package org.example.services;

import org.example.model.CompositionBasketRelation;
import java.util.List;

public interface CompositionBasketRelationService {
    CompositionBasketRelation getById(int id);
    List<CompositionBasketRelation> getAllByBasketId(int id);
    CompositionBasketRelation addCompositionInBasket(int compositionId,int basketId);

    boolean deleteCompositionFromBasket(int compositionId, int basketId);
}
