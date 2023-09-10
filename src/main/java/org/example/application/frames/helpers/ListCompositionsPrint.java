package org.example.application.frames.helpers;

import org.example.Helper;
import org.example.Top;
import org.example.model.Composition;
import org.example.model.Performer;

import java.util.List;

public class ListCompositionsPrint {
    public static void print(String text, List<Composition> compositions){
        for (Composition composition : compositions) {
            String genreName = Top.genreService.getById(composition.getGenreId()).getName();
            composition.setGenreName(genreName);

            Performer performer = Top.performerService.getById(composition.getPerformerId());
            String performerName = performer.getFirstName() + "_" + performer.getMiddleName() + "_" + performer.getLastName();
            composition.setPerformerName(performerName);
        }

        Helper.printList(text,compositions);
    }

}
