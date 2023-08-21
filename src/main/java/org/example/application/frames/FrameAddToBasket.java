package org.example.application.frames;

import org.example.Helper;
import org.example.application.Input;
import org.example.model.Basket;
import org.example.Top;

public class FrameAddToBasket extends FrameImitation{
    private int compositionId;

    public FrameAddToBasket(int compositionId) {
        this.compositionId = compositionId;
    }

    @Override
    public FrameImitation start(Input input) {
        Helper.printLine("корзины, которые к вам привязаны, что бы добавить композицию в одну из них выберите её индекс и нажмите ввод");
        for (Basket basket : Top.getCurrentBasket()) {
            System.out.println(basket);
        }

        int basketId = input.start().getNextInt();
        if(Top.basketCompositionService.addCompositionInBasket(compositionId,basketId)){
            return new FrameInformation("добавлено в корзину");
        }

        return null;
    }
}
