package org.example;

import org.example.model.User;
import org.example.services.*;
import org.example.services.implementations.*;

public class Top {
    // service //
    public static final CompositionService compositionService = new CompositionServiceImpl();
    public static final GenreService genreService = new GenreServiceImpl();
    public static final PerformerService performerService = new PerformerServiceImpl();

    public static final BasketService basketService = new BasketServiceImpl();
    public static final CompositionBasketRelationService compositionBasketRelationService = new CompositionBasketRelationServiceImpl();
    public static final UserService userService = new UserServiceImpl();

    public static User user = new User();
    //public static User user = new User(2,"user2","2",StringValues.UserType.CUSTOMER);
    //public static User user = new User(7,"admin1","1",StringValues.UserType.ADMIN);

    public static boolean admin(){
        return user.getType().equals(StringValues.UserType.ADMIN); }
    public static boolean customer(){ return user.getType().equals(StringValues.UserType.CUSTOMER); }

    public static boolean entry(){
        if(user.getType().equals("")){
            return false;
        }
        return true;
    }
    public static boolean signIn(String login,String password){
        for (User user : userService.getAll()) {
            if (login.equals(user.getName()) && password.equals(user.getPassword())) {
                Top.user = user;
                return true;
            }
        }

        return false;
    }

}
