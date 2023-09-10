package org.example.application.frames;

import org.example.Helper;
import org.example.application.Input;
import org.example.application.frames.helpers.FrameImitation;
import org.example.model.Genre;
import org.example.Top;

import java.util.List;

public class FrameGenres extends FrameImitation {
    @Override
    public FrameImitation start(Input input) {
        List<Genre> genres = Top.genreService.getAll();
        Helper.printList("СПИСОК ЖАНРОВ",genres);

        Helper.printLine("Введите номер жанра что бы получить больше информации о нём");
        if(Top.admin()){
            Helper.printLine("Нажмите n что бы добавить новый жанр");
        }

        input.start();

        if(input.getNextInt()>0){
            return new FrameGenre(genres.get(input.getNextInt() - 1));
        }
        if(Top.admin() && input.getNextString().equals("n")){
            return new FrameAddNewGenre();
        }
        return  null;
    }

}
