package org.example.application.frames;

import org.example.Helper;
import org.example.application.Input;
import org.example.model.Composition;
import org.example.Top;

public class FrameComposition extends FrameImitation{
    private int compositionId;
    public FrameComposition(int compositionId) {
        this.compositionId = compositionId;
    }
    @Override
    public FrameImitation start(Input input) {
        Composition composition = Top.compositionService.getById(compositionId);
        Helper.printLine(composition.toString());
        Helper.printLine(
                "нажмите 1 что бы добавить композицию в корзину",
                "нажмите 2 что бы получить более подробную информацию об исполнителе"
        );

        int i = input.start().getNextInt();
        switch (i){
            case 1:
                if(Top.entry()){
                    return new FrameAddToBasket(compositionId);
                }else{
                    return new FrameInformation("Вы не вошли в систему либо не зарегестрированны");
                }
            case 2:
                return new FramePerformer(composition.getPerformerId());
        }

        return null;
    }
}
