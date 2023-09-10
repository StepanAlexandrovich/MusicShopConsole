package org.example.model;

import org.example.Top;

import java.util.ArrayList;
import java.util.List;

public class Basket implements ObjectWithId{
    private int id;
    private boolean status; // false - сборка корзины true - уже оплаченна и архивная
    private int userId;
    private List<CompositionBasketRelation> compositions = new ArrayList<>();
    public Basket(int id, boolean status, int userId) {
        this.id = id;
        this.status = status;
        this.userId = userId;
    }
    public int getId() {
        return id;
    }
    public boolean isStatus() {
        return status;
    }
    public String statusText(){
        if(status){ return "оплачена"; }
        else      { return "не оплачена"; }
    }

    ////////////////////
    public List<CompositionBasketRelation> details() {
        return Top.compositionBasketRelationService.getAllByBasketId(id);
    }
    public CompositionBasketRelation addComposition(Composition composition){
        return Top.compositionBasketRelationService.addCompositionInBasket(composition.getId(),id);
    }
    public boolean deleteComposition(Composition composition){
        return Top.compositionBasketRelationService.deleteCompositionFromBasket(composition.getId(),id);
    }
    @Override
    public String toString() {
        return "Basket{" +
                " status=" + statusText() +
                '}';
    }

}
