package org.example.application.frames;

import org.example.Helper;
import org.example.application.Input;
import org.example.model.Genre;
import org.example.Top;
public class FrameGenres extends FrameImitation{
    @Override
    public FrameImitation start(Input input) {
        System.out.println("СПИСОК ЖАНРОВ");
        for (Genre genre: Top.genreService.getAll()){
            System.out.println(genre.getId()+" "+genre.getName());
        }
        Helper.printLine("Выберите жанр что бы получить больше информации о нём");

        int i = input.start().getNextInt();
        if(i>0){
            return new FrameGenre(i);
        }
        return null;
    }

}
