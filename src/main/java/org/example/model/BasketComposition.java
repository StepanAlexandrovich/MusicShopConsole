package org.example.model;

public class BasketComposition implements ObjectWithId{
    private int id;
    private int count;
    private int compositionId;

    private int basketId;
    private Composition composition;

    public BasketComposition(int id, int count, int compositionId, int basketId) {
        this.id = id;
        this.count = count;
        this.compositionId = compositionId;
        this.basketId = basketId;
    }

    @Override
    public int getId() {
        return id;
    }
    public int getCount() {
        return count;
    }
    public int getCompositionId() { return compositionId; }
    public int getBasketId() { return basketId; }

    //-----------------------------------//
    public Composition getComposition() {
        return composition;
    }
    public void setComposition(Composition composition) {
        this.composition = composition;
    }

    @Override
    public String toString() {
        return  composition.toString() +
                ", count=" + count +
                '}';
    }
}
