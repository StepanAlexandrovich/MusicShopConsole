package org.example.application.frames;

import org.example.Helper;
import org.example.application.Input;
import org.example.Top;

public class FrameMenu extends FrameImitation{
    @Override
    public FrameImitation start(Input input) {
        Helper.printLine("ГЛАВНОЕ МЕНЮ",
                "1 -> получить список жанров",
                "2 -> получить список композиций",
                "3 -> получить список исполнителей",
                "4 -> произвести операции с корзинами",
                "5 -> войти в систему",
                "6 -> зарегестрироваться"
        );

        switch (input.start().getNextInt()){
            case 1: return new FrameGenres();
            case 2: return new FrameCompositions();
            case 3: return new FramePerformers();

            case 4:
                if(Top.entry()){
                    return new FrameBaskets();
                }else{
                    return new FrameInformation("Вам необходимо зарегестрироваться либо войти в систему что бы получить доступ к корзине");
                }

                // TODO: при добавлении в баскет предусмотреть количество композиций
                // TODO: оплата корзины(измен статуса)
            case 5: return new FrameEnter();
        }

        return null;
    }

}
