package org.example.application.frames;

import org.example.Helper;
import org.example.application.Input;
import org.example.application.frames.helpers.FrameImitation;
import org.example.model.Composition;
import org.example.Top;

public class FrameComposition extends FrameImitation {

    private Composition composition;

    public FrameComposition(Composition composition) {
        this.composition = composition;
    }

    @Override
    public FrameImitation start(Input input) {
        Helper.printLine(composition.toString());
        Helper.printLine(
                "нажмите 1 что бы получить больше информации о жанре",
                "нажмите 2 что бы получить более подробную информацию об исполнителе"
        );

        if(Top.customer()){
            Helper.printLine("нажмите 3 что бы добавить композицию в корзину");
        }else
        if(Top.admin()){
            Helper.printLine("нажмите 3 что бы удалить композицию из базы данных");
        }

        int i = input.start().getNextInt();
        switch (i){
            case 1: return new FrameGenre(composition.getGenre());
            case 2: return new FramePerformer(composition.getPerformer());
        }

        if(Top.customer() && i == 3){
            return new FrameAddCompositionToBasket(composition);
        }else
        if(Top.admin() && i == 3){
            if(Top.compositionService.deleteById(composition.getId())!=null){
                return new FrameInformation("композиция удалена");
            }else{
                return new FrameInformation("По неизвестным причинам композиция не удалена");
            }
        }

        return null;
    }
}
