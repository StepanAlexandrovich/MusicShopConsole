package org.example.repositories;

import org.example.model.Composition;
import org.example.repositories.functional.FindAll;
import org.example.repositories.functional.FindByFewId;
import org.example.repositories.functional.FindById;

import java.time.LocalDate;
import java.util.List;

public interface CompositionRepository extends UniversalRepository<Composition>, FindByFewId {
    List<Composition> findAllByGenreId(int id);
    List<Composition> findAllByPerformerId(int id);
    Composition add(String name, LocalDate dateRelease, double duration, double price, int genreId, int performerId);

}