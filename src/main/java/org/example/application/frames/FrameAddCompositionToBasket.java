package org.example.application.frames;

import org.example.Helper;
import org.example.application.Input;
import org.example.application.frames.helpers.FrameImitation;
import org.example.model.Basket;
import org.example.Top;
import org.example.model.Composition;

import java.util.List;

public class FrameAddCompositionToBasket extends FrameImitation {
    private Composition composition;
    public FrameAddCompositionToBasket(Composition composition) {
        this.composition = composition;
    }
    @Override
    public FrameImitation start(Input input) {
        List<Basket> baskets = Top.user.getBaskets();
        Helper.printList("корзины, которые к вам привязаны",baskets);
        Helper.printLine("введите индекс корзины в которую хотите добавить композицию");

        input.start();

        if(baskets.get(input.getNextInt() - 1).addComposition(composition) !=null){
            return new FrameInformation("добавлено в корзину");
        }
        return null;
    }
}
