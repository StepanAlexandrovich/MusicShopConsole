package org.example.application.frames;

import org.example.Helper;
import org.example.Top;
import org.example.application.Input;
import org.example.application.frames.helpers.FrameImitation;
import org.example.application.frames.helpers.ListCompositionsPrint;
import org.example.model.Composition;
import org.example.model.Genre;

import java.util.List;

public class FrameGenre extends FrameImitation {
    private Genre genre;
    public FrameGenre(Genre genre) {
        this.genre = genre;
    }
    @Override
    public FrameImitation start(Input input) {
        Helper.printLine(genre.toString());
        List<Composition> compositions = genre.getCompositions();
        ListCompositionsPrint.print("СПИСОК КОМПОЗИЦИЙ ОТНОСЯЩИХСЯ К ДАННОМУ ЖАНРУ",compositions);

        Helper.printLine("Что бы выбрать композицию из данного жанра наберите её индекс");
        if(Top.admin()){
            Helper.printLine("нажмите d (delete) что бы удалить жанр из базы данных");
        }

        input.start();

        if(input.getNextInt()>0){
            return new FrameComposition(compositions.get(input.getNextInt() - 1));
        }else
        if(Top.admin() && input.getNextString().equals("d")){
            if(Top.genreService.deleteById(genre.getId())!=null){
                return new FrameInformation("жанр удалён");
            }else{
                return new FrameInformation("По неизвестным причинам жанр не удалён");
            }
        }

        return null;
    }
}
