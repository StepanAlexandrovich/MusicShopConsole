package org.example.model;

import org.example.Top;

import java.util.List;

public class User implements ObjectWithId{
    private int id;
    private String name = "";
    private String password = "";
    private String type = "";

    public User(int id, String name, String password, String type) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.type = type;
    }
    public User() {}

    @Override
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public String getType() { return type; }
    public List<Basket> getBaskets(){
        return Top.basketService.getAllByUserId(id);
    }
}
