package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    private List<User> users = new ArrayList<User>();

    public User getUser(int index){
        return users.get(index);
    }

    public void addUser(User user) {
        users.add(user);
    }




}
