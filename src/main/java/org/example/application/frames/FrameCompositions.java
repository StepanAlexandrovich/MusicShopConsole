package org.example.application.frames;

import org.example.Helper;
import org.example.application.Input;
import org.example.application.frames.helpers.FrameImitation;
import org.example.application.frames.helpers.ListCompositionsPrint;
import org.example.model.Composition;
import org.example.Top;

import java.util.List;

public class FrameCompositions extends FrameImitation {
    @Override
    public FrameImitation start(Input input) {
        List<Composition> compositions = Top.compositionService.getAll();
        ListCompositionsPrint.print("СПИСОК КОМПОЗИЦИЙ",compositions);

        Helper.printLine("Введите номер композиции что бы произвести операции с ней");
        if(Top.admin()){
            Helper.printLine("Нажмите n что бы добавить новую композицию");
        }

        input.start();

        if(input.getNextInt()>0){
            return new FrameComposition(compositions.get(input.getNextInt() - 1));
        }
        if(Top.admin() && input.getNextString().equals("n")){
            return new FrameAddNewComposition();
        }
        return null;
    }

}
