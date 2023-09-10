package org.example.repositories.implementations.txt;

import org.example.model.Performer;
import org.example.repositories.PerformerRepository;
import org.example.Top;
import org.example.repositories.implementations.txt.universal.TakeObjectsFromTxt;

import java.util.List;

public class PerformerRepositoryImpl implements PerformerRepository {
    private String path = "src/main/resources/performers.txt";
    private TakeObjectsFromTxt<Performer> takeObjectsFromTxt = new TakeObjectsFromTxt<Performer>(path) {
        @Override
        public Performer createObject(String line) {
            return createPerformerFromWords(line.split(";"));
        }
        private Performer createPerformerFromWords(String[] words){

            return new Performer(
                    Integer.parseInt(words[0]),
                    words[1],
                    "empty",
                    words[2],
                    "description",
                    words[3]
            );
        }

    };

    public PerformerRepositoryImpl() {
    }

    @Override
    public List<Performer> findAll() {
        return takeObjectsFromTxt.findAll();
    }

    @Override
    public Performer findById(int id) {
        return takeObjectsFromTxt.findById(id);
    }

    @Override
    public Performer add(String firstName, String middleName, String lastName,String description, String country) {
        System.out.println("empty");
        return null;
    }

    @Override
    public Performer findByName(String name) {
        System.out.println("empty");
        return null;
    }

    @Override
    public Performer deleteById(int id) {
        System.out.println("empty");
        return null;
    }
}
