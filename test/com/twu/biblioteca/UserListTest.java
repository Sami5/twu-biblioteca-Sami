package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserListTest {

    UserList userList = new UserList();

    @Test
    public void testGetAvailableBook() {
        userList.addUser(new User("243-9405", "fsl5", "Nicole Jones", "nicole@hotmail.com", "0455555555"));
        String expected = String.format("%-30s%-30s%-30s%-30s%-20s", "243-9405", "fsl5", "Nicole Jones", "nicole@hotmail.com", "0455555555");
        System.out.println(userList.getUser(0).showAll());
        assertEquals(expected, userList.getUser(0).showAll().toString());
    }

}
