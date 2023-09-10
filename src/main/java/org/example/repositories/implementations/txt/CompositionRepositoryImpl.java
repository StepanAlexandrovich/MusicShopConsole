package org.example.repositories.implementations.txt;

import org.example.model.Composition;
import org.example.repositories.CompositionRepository;
import org.example.repositories.implementations.txt.universal.TakeObjectsFromTxt;

import java.time.LocalDate;
import java.util.List;

public class CompositionRepositoryImpl<T extends Composition> implements CompositionRepository {
    String path = "src/main/resources/compositions.txt";

    TakeObjectsFromTxt<Composition> takeObjectsFromTxt = new TakeObjectsFromTxt<Composition>(path) {
        @Override
        public Composition createObject(String line) {

        String[] words = line.split(";");

        String[] dataValues = words[2].split("-");
        LocalDate data = LocalDate.of(
                Integer.parseInt(dataValues[0]),
                Integer.parseInt(dataValues[1]),
                Integer.parseInt(dataValues[2]) );  /////////////////////// переделать

        Composition composition = new Composition(
                Integer.parseInt(words[0]),
                words[1],data,
                Double.parseDouble(words[3]),
                Double.parseDouble(words[4]),
                Integer.parseInt(words[5]),
                Integer.parseInt(words[6]));

        return composition;
        }

    };
    @Override
    public List<Composition> findAll() {
        return takeObjectsFromTxt.findAll();
    }
    @Override
    public Composition findById(int id) {
        return takeObjectsFromTxt.findById(id);
    }
    @Override
    public List findByFewId(List fewId) {
        return takeObjectsFromTxt.findByFewId(fewId);
    }

    @Override
    public List<Composition> findAllByGenreId(int id) {
        return takeObjectsFromTxt.list(5,id);
    }

    @Override
    public List<Composition> findAllByPerformerId(int id) {
        return takeObjectsFromTxt.list(6,id);
    }

    @Override
    public Composition add(String name, LocalDate dateRelease, double duration, double price, int genreId, int performerId) {
        System.out.println("empty");
        return null;
    }

    @Override
    public Composition deleteById(int id) {
        System.out.println("empty");
        return null;
    }
}
