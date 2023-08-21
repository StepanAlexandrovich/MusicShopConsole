package org.example.services;

import org.example.model.BasketComposition;
import java.util.List;

public interface BasketCompositionService {
    List<BasketComposition> getAllByBasketId(int id);
    boolean addCompositionInBasket(int compositionId,int basketId);
}
