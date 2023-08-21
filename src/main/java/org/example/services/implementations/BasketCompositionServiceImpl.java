package org.example.services.implementations;

import org.example.application.ReadText;
import org.example.application.WriteText;
import org.example.model.BasketComposition;
import org.example.repositories.BasketCompositionRepository;
import org.example.repositories.implementations.BasketCompositionRepositoryImpl;
import org.example.services.BasketCompositionService;
import org.example.repositories.implementations.OneToManyImpl;
import org.example.Top;

import java.util.List;

public class BasketCompositionServiceImpl implements BasketCompositionService {
    private BasketCompositionRepository basketCompositionRepository = new BasketCompositionRepositoryImpl();
    private OneToManyImpl<BasketCompositionRepository> oneToMany= new OneToManyImpl<>(basketCompositionRepository,"src/main/resources/basket_compositions.txt");
    String path = "src/main/resources/basket_compositions.txt";
    WriteText writeText = new WriteText();
    ReadText readText = new ReadText();
    @Override
    public List<BasketComposition> getAllByBasketId(int id) {
        return oneToMany.setFirstLast(0,3).list(id);
    }
    @Override
    public boolean addCompositionInBasket(int compositionId,int basketId) {

        // весь код перенести в репозиторий

        if(Top.entry()){  // проверку на допустимую карзину
            int id = readText.lastIndex(path) + 1;
            int count = 1;


            for (BasketComposition basketComposition : basketCompositionRepository.findAll()) {
                if(basketComposition.getComposition().getId() == compositionId && basketComposition.getBasketId() == basketId){
                    System.out.println("Эта композиция уже у вас добавлена");
                }
            }

            String text = "" + id + ";" + count + ";" + compositionId + ";" + basketId;
            writeText.write(path,text);

            return true;
        }
        return false;
    }
}
