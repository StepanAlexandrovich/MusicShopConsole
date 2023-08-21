package org.example.application.frames;

import org.example.Helper;
import org.example.application.Input;
import org.example.model.Composition;
import org.example.model.Genre;
import org.example.Top;

public class FrameGenre extends FrameImitation{
    private int idGenre;
    public FrameGenre(int idGenre) {
        this.idGenre = idGenre;
    }
    @Override
    public FrameImitation start(Input input) {
        Genre genre = Top.genreService.getById(idGenre);
        Helper.printLine(genre.toString());

        System.out.println("----------------------------------------");
        System.out.println("СПИСОК ПЕСЕН ОТНОСЯЩИХСЯ К ДАННОМУ ЖАНРУ");
        for (Composition composition : genre.getCompositions()) {
            System.out.println(composition.getId()+" "+composition.getName());
        }
        System.out.println("----------------------------------------");

        Helper.printLine("Что бы выбрать композицию из данного жанра наберите её индекс");

        int i = input.start().getNextInt();
        if(i>0){
            return new FrameComposition(i);
        }
        return null;
    }
}
