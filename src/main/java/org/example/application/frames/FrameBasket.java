package org.example.application.frames;

import org.example.Helper;
import org.example.application.Input;
import org.example.application.frames.helpers.FrameImitation;
import org.example.model.Basket;
import org.example.model.Composition;
import org.example.model.CompositionBasketRelation;

import java.util.List;

public class FrameBasket extends FrameImitation {
    private Basket basket;
    public FrameBasket(Basket basket) {
        this.basket = basket;
    }
    @Override
    public FrameImitation start(Input input) {
        List<CompositionBasketRelation> compositionBasketRelations = basket.details();
        Helper.printList("СПИСОК ДОБАВЛЕННЫХ КОМПОЗИЦИЙ",basket.details());

        Helper.printLine(
                "введите p(pay) что бы оплатить корзину(empty)",
                "введите число r(reset) что бы очистить корзину(empty)",
                "введите номер композиции что бы удалить её из корзины"
                );

        input.start();

        switch (input.getNextString()){
            case "p":
                // TODO: 10.09.2023
                return new FrameInformation("оплаченно");
            case "r":
                // TODO: 10.09.2023
                return new FrameInformation("очищенно");
        }

        if(input.getNextInt()>0){
            Composition composition = compositionBasketRelations.get(input.getNextInt() - 1).getComposition();
            if(basket.deleteComposition(composition)){
                return new FrameInformation("удалено");
            }
        }
        return null;
    }
}
