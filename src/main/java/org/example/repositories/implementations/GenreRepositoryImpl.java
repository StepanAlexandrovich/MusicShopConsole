package org.example.repositories.implementations;

import org.example.model.Genre;
import org.example.repositories.GenreRepository;
import org.example.services.CompositionService;
import org.example.Top;
import org.example.services.implementations.CompositionServiceImpl;

import java.util.List;

public class GenreRepositoryImpl implements GenreRepository{
    String path = "src/main/resources/genres.txt";
    CreateObjectFromString<Genre> createObjectFromString = new CreateObjectFromString<Genre>(path) {
        @Override
        public Genre createObject(String line) {
            Genre genre = createGenreFromWords(line.split(";"));
            genre.setCompositions(Top.compositionService.getAllByGenreId(genre.getId()));
            return genre;
        }
        private Genre createGenreFromWords(String[] words){
            return new Genre(Integer.parseInt(words[0]),words[1],words[2]);
        }
    };

    @Override
    public Genre findById(int id) {
        return createObjectFromString.findById(id);
    }
    @Override
    public List<Genre> findAll() {
        return createObjectFromString.findAll();
    }

}
