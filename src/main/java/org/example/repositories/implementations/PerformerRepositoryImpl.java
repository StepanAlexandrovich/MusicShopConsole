package org.example.repositories.implementations;

import org.example.model.Performer;
import org.example.repositories.PerformerRepository;
import org.example.Top;

import java.util.List;

public class PerformerRepositoryImpl implements PerformerRepository {
    private String path = "src/main/resources/performers.txt";
    private CreateObjectFromString<Performer> createObjectFromString = new CreateObjectFromString<Performer>(path) {
        @Override
        public Performer createObject(String line) {
            Performer performer = createPerformerFromWords(line.split(";"));
            performer.setCompositions( Top.compositionService.getAllByPerformerId(performer.getId()) );
            return performer;
        }
        private Performer createPerformerFromWords(String[] words){
            return new Performer(
                    Integer.parseInt(words[0]),
                    words[1],
                    words[2],
                    words[3]
            );
        }

    };

    @Override
    public List<Performer> findAll() {
        return createObjectFromString.findAll();
    }

    @Override
    public Performer findById(int id) {
        return createObjectFromString.findById(id);
    }

}
