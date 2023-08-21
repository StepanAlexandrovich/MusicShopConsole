package org.example.application.frames;

import org.example.Helper;
import org.example.application.Input;
import org.example.model.Composition;
import org.example.Top;

public class FrameCompositions extends FrameImitation{
    @Override
    public FrameImitation start(Input input) {
        Helper.printLine("СПИСОК КОМПОЗИЦИЙ");
        for (Composition composition: Top.compositionService.getAll()){
            System.out.println(composition.getId() + " " + composition.getName());
        }

        Helper.printLine("нажмите номер композиции что бы получить более подробную информацию о ней");
        int i = input.start().getNextInt();
        if(i>0){
            return new FrameComposition(i);
        }
        return null;
    }

}
