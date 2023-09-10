package org.example.model;

import org.example.Top;

public class CompositionBasketRelation implements ObjectWithId{
    private int id;
    private int countOfCompositions;
    private int compositionId;
    private int basketId;

    public CompositionBasketRelation(int id, int countOfCompositions, int compositionId, int basketId) {
        this.id = id;
        this.countOfCompositions = countOfCompositions;
        this.compositionId = compositionId;
        this.basketId = basketId;
    }

    @Override
    public int getId() {
        return id;
    }
    public int getCountOfCompositions() {
        return countOfCompositions;
    }
    public int getCompositionId() { return compositionId; }
    public int getBasketId() { return basketId; }

    //-----------------------------------//
    public Composition getComposition() {
        return Top.compositionService.getById(compositionId);
    }

    @Override
    public String toString() {
        return  getComposition() +
                ", count=" + countOfCompositions +
                '}';
    }
}
