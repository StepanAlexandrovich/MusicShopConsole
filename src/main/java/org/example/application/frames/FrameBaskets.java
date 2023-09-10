package org.example.application.frames;

import org.example.Helper;
import org.example.application.Input;
import org.example.application.frames.helpers.FrameImitation;
import org.example.model.Basket;

import java.util.List;

public class FrameBaskets extends FrameImitation {
    private List<Basket> baskets;

    public FrameBaskets(List<Basket> baskets) {
        this.baskets = baskets;
    }

    @Override
    public FrameImitation start(Input input) {
        Helper.printList("Корзины, которые к вам привязаны",baskets);
        Helper.printLine("Введите индекс корзины что бы выбрать одну из них");

        int i = input.start().getNextInt();
        if(i>0){
            return new FrameBasket(baskets.get(i - 1));
        }
        return null;
    }
}
