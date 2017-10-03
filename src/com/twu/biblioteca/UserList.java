package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    private static List<User> users = new ArrayList<User>();

    public static User getUser(int index){
        return users.get(index);
    }

    public static void addUser(User user) {
        users.add(user);
    }




}
