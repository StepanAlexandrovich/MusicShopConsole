package org.example.repositories.implementations.txt;

import org.example.model.Genre;
import org.example.repositories.GenreRepository;
import org.example.repositories.implementations.txt.universal.TakeObjectsFromTxt;
import org.example.Top;

import java.util.List;

public class GenreRepositoryImpl implements GenreRepository{
    String path = "src/main/resources/genres.txt";
    TakeObjectsFromTxt<Genre> takeObjectsFromTxt = new TakeObjectsFromTxt<Genre>(path) {
        @Override
        public Genre createObject(String line) {
            return createGenreFromWords(line.split(";"));
        }
        private Genre createGenreFromWords(String[] words){
            return new Genre(Integer.parseInt(words[0]),words[1],words[2]);
        }
    };

    @Override
    public Genre findById(int id) {
        return takeObjectsFromTxt.findById(id);
    }
    @Override
    public List<Genre> findAll() {
        return takeObjectsFromTxt.findAll();
    }

    // EMPTY //
    @Override
    public Genre findByName(String name) {
        System.out.println("empty");
        return null;
    }
    @Override
    public Genre add(String name, String description) {
        System.out.println("empty");
        return null;
    }
    @Override
    public Genre deleteById(int id) {
        System.out.println("empty");
        return null;
    }
}
