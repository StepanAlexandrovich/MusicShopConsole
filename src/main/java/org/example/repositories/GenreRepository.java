package org.example.repositories;

import org.example.model.Genre;
import org.example.model.Performer;
import org.example.repositories.functional.FindAll;
import org.example.repositories.functional.FindById;

public interface GenreRepository extends UniversalRepository<Genre>{
    Genre findByName(String name);
    Genre add(String name, String description);
    //Genre delete(int id);

    // убрать
    //Genre addGenre(String name, String description);

}