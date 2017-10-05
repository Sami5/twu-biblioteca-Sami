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
/*
    public boolean checkLibraryNumberExists(String libraryNumber) {
        int index = getIndexByLibraryNumberInUsers(libraryNumber);
        if (index >= 0) {
            return true;
        } else {
            return false;
        }
    }
*/
    public int getIndexByLibraryNumberInUsers(String libraryNumber) {
        for(User x: users) {
            if(x.getLibraryNumber().equals(libraryNumber)) {
                return users.indexOf(x);
            }
        }
        return -1;
    }

}
