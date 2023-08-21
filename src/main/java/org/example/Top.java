package org.example;

import org.example.model.Basket;
import org.example.model.User;
import org.example.services.*;
import org.example.services.implementations.*;

import java.util.List;

public class Top {
    // service //
    public static final CompositionService compositionService = new CompositionServiceImpl();
    public static final GenreService genreService = new GenreServiceImpl();
    public static final PerformerService performerService = new PerformerServiceImpl();

    public static final BasketService basketService = new BasketServiceImpl();
    public static final BasketCompositionService basketCompositionService = new BasketCompositionServiceImpl();
    public static final UserService userService = new UserServiceImpl();

    //----------------------------------
    // LOGIC
    //----------------------------------
    public static int idCurrentUser = 0;
    public static boolean entry(){
        if(idCurrentUser >0){
            return true;
        }
        return false;
    }
    public static boolean signIn(String login,String password){
        for (User user : userService.getAll()) {
            if (login.equals(user.getUsername()) && password.equals(user.getPassword())) {
                idCurrentUser = user.getId();
                return true;
            }
        }

        return false;
    }
    public static List<Basket> getCurrentBasket(){
        return basketService.getAllByUserId(idCurrentUser);
    }

}
