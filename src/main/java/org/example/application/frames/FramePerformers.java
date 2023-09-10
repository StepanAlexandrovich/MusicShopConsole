package org.example.application.frames;

import org.example.Helper;
import org.example.application.Input;
import org.example.application.frames.helpers.FrameImitation;
import org.example.model.Performer;
import org.example.Top;

import java.util.List;

public class FramePerformers extends FrameImitation {
    @Override
    public FrameImitation start(Input input) {
        List<Performer> performers = Top.performerService.getAll();
        Helper.printList("СПИСОК ИСПОЛНИТЕЛЕЙ",performers);

        Helper.printLine("нажмите номер исполнителя что бы получить более подробную информацию о нем");
        if(Top.admin()){
            Helper.printLine("Нажмите n что бы добавить нового исполнителя");
        }

        input.start();

        if(input.getNextInt()>0){
            return new FramePerformer(performers.get(input.getNextInt() - 1));
        }
        if(Top.admin() && input.getNextString().equals("n")){
            return new FrameAddNewPerformer();
        }
        return null;
    }

}
