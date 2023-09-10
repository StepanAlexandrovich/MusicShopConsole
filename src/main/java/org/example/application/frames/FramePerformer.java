package org.example.application.frames;

import org.example.Helper;
import org.example.application.Input;
import org.example.application.frames.helpers.FrameImitation;
import org.example.application.frames.helpers.ListCompositionsPrint;
import org.example.model.Composition;
import org.example.model.Performer;
import org.example.Top;

import java.util.List;

public class FramePerformer extends FrameImitation {
    private Performer performer;
    public FramePerformer(Performer performer) {
        this.performer = performer;
    }

    @Override
    public FrameImitation start(Input input) {
//        Helper.printLine(performer.toString());
//
//        List<Composition> compositions = Top.compositionService.getAllByPerformerId(performer.getId());
//        ListCompositionsPrint.print("СПИСОК ЕГО КОМПОЗИЦИЙ",compositions);
//
//        Helper.printLine("Что бы выбрать одну из его песен введите её индекс");
//
//        int i = input.start().getNextInt();
//        if(i>0){
//            return new FrameComposition(compositions.get(i - 1));
//        }
//        return null;


        Helper.printLine(performer.toString());
        List<Composition> compositions = performer.getCompositions();
        ListCompositionsPrint.print("СПИСОК КОМПОЗИЦИЙ ДАННОГО ИСПОЛНИТЕЛЯ",compositions);

        Helper.printLine("Что бы выбрать композицию из данного жанра наберите её индекс");
        if(Top.admin()){
            Helper.printLine("нажмите d (delete) что бы удалить этого исполнителя из базы данных");
        }

        input.start();

        if(input.getNextInt()>0){
            return new FrameComposition(compositions.get(input.getNextInt() - 1));
        }else
        if(Top.admin() && input.getNextString().equals("d")){
            if(Top.performerService.deleteById(performer.getId())!=null){
                return new FrameInformation("исполнитель удалён");
            }else{
                return new FrameInformation("По неизвестным причинам исполнитель не удалён");
            }
        }

        return null;
    }
}
