package org.example.application.frames;

import org.example.Helper;
import org.example.application.Input;
import org.example.model.BasketComposition;
import org.example.Top;

public class FrameBasket extends FrameImitation{
    private int basketId;
    public FrameBasket(int basketId) {
        this.basketId = basketId;
    }
    @Override
    public FrameImitation start(Input input) {
        Helper.printLine("СПИСОК ДОБАВЛЕННЫХ КОМПОЗИЦИЙ");
        for (BasketComposition composition : Top.basketService.getById(basketId).getCompositions()) {
            System.out.println(composition);
        }

        Helper.printLine(
                "введите число ... что бы оплатить корзину",
                "введите число 200 что бы очистить корзину",
                "введите номер композиции что бы удалить её из корзины"
                );

        int i = input.start().getNextInt();

//        switch (i){
//
//        }

        return null;
    }
}
