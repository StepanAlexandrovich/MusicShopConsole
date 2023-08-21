package org.example.application.frames;

import org.example.Helper;
import org.example.application.Input;
import org.example.model.Performer;
import org.example.Top;

public class FramePerformers extends FrameImitation{
    @Override
    public FrameImitation start(Input input) {
        Helper.printLine("СПИСОК ИСПОЛНИТЕЛЕЙ");
        for (Performer performer: Top.performerService.getAll()){
            System.out.println(performer.getId() + " " + performer.getName());
        }

        Helper.printLine("нажмите номер исполнителя что бы получить более подробную информацию о нем");
        int i = input.start().getNextInt();
        if(i > 0){
            return new FramePerformer(i);
        }
        return null;
    }

}
