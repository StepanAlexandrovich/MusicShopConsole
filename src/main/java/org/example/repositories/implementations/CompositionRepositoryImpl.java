package org.example.repositories.implementations;

import org.example.model.Composition;
import org.example.repositories.CompositionRepository;

import java.time.LocalDate;
import java.util.List;

public class CompositionRepositoryImpl<T extends Composition> implements CompositionRepository {
    String path = "src/main/resources/compositions.txt";

    CreateObjectFromString<Composition> createObjectFromString = new CreateObjectFromString<Composition>(path) {
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
        return createObjectFromString.findAll();
    }
    @Override
    public Composition findById(int id) {
        return createObjectFromString.findById(id);
    }
    @Override
    public List findByFewId(List fewId) {
        return createObjectFromString.findByFewId(fewId);
    }
}
