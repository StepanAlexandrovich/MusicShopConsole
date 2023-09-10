package org.example.application.frames;

import org.example.Helper;
import org.example.application.Input;
import org.example.Top;
import org.example.application.frames.helpers.FrameImitation;

public class FrameMenu extends FrameImitation {
    @Override
    public FrameImitation start(Input input) {
        Helper.printLine("ГЛАВНОЕ МЕНЮ",
                "1 -> получить список жанров",
                "2 -> получить список композиций",
                "3 -> получить список исполнителей",
                "4 -> войти в систему",
                "5 -> зарегестрироваться"
        );

        if(Top.customer()){
            Helper.printLine("6 -> произвести операции с корзинами");
        }

        input.start();

        switch (input.getNextInt()){
            case 1: return new FrameGenres();
            case 2: return new FrameCompositions();
            case 3: return new FramePerformers();
            case 4: return new FrameEnter();
            case 5: // TODO: do it
        }

        if(Top.customer()&&input.getNextInt() == 6){
            // TODO: оплата корзины(измен статуса)
            return new FrameBaskets(Top.user.getBaskets());
        }

        return null;
    }

}
