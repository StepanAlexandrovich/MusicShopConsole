package org.example.repositories;

import org.example.model.CompositionBasketRelation;
import org.example.repositories.functional.FindAll;
import org.example.repositories.functional.FindByFewId;
import org.example.repositories.functional.FindById;

import java.util.List;

public interface CompositionBasketRelationRepository extends FindAll<CompositionBasketRelation>, FindById<CompositionBasketRelation>, FindByFewId<CompositionBasketRelation> {
    CompositionBasketRelation addCompositionToBasket(int compositionId, int basketId);
    List<CompositionBasketRelation> findAllByBasketId(int id);
    boolean deleteCompositionFromBasket(int compositionId, int basketId);
}
