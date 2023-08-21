package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Basket implements ObjectWithId{
    private int id;
    private boolean status; // false - сборка корзины true - уже оплаченна и архивная

    private int userId;

    private List<BasketComposition> compositions = new ArrayList<>();

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

    ////////////////////
    public List<BasketComposition> getCompositions() {
        return compositions;
    }

    public void setCompositions(List<BasketComposition> compositions) {
        this.compositions = compositions;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
