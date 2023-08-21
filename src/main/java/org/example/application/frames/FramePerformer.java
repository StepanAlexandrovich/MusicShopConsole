package org.example.application.frames;

import org.example.Helper;
import org.example.application.Input;
import org.example.model.Composition;
import org.example.model.Performer;
import org.example.Top;

public class FramePerformer extends FrameImitation{
    private int idPerformer;
    public FramePerformer(int idPerformer) {
        this.idPerformer = idPerformer;
    }
    @Override
    public FrameImitation start(Input input) {
        Performer performer = Top.performerService.getById(idPerformer);
        Helper.printLine(performer.toString());

        System.out.println("----------------------------------------");
        System.out.println("ЕГО СПИСОК ПЕСЕН");
        for (Composition composition : performer.getCompositions()) {
            System.out.println(composition.getId()+" "+composition.getName());
        }
        System.out.println("----------------------------------------");

        Helper.printLine("Что бы выбрать одну из его песен введите её индекс");

        int i = input.start().getNextInt();
        if(i>0){
            return new FrameComposition(i);
        }
        return null;
    }
}
