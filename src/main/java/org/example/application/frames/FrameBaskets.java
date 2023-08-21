package org.example.application.frames;

import org.example.Helper;
import org.example.application.Input;
import org.example.model.Basket;
import org.example.Top;

public class FrameBaskets extends FrameImitation {
    @Override
    public FrameImitation start(Input input) {
        Helper.printLine("корзины, которые к вам привязаны, выберите одну из них");
        for (Basket basket : Top.getCurrentBasket()) {
            System.out.println(basket);
        }

        int i = input.start().getNextInt(); // сделать безопасность

        if(i>0){
            return new FrameBasket(i);
        }

        return null;
    }
}
