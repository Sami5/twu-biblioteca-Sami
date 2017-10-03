package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserListTest {

    @Test
    public void testGetAvailableBook() {
        User user1 = new User("243-9405", "fsl5", "Nicole Jones", "nicole@hotmail.com", "0455555555");
        String expected = String.format("%-30s%-30s%-30s%-30s%-20s", "243-9405", "fsl5", "Nicole Jones", "nicole@hotmail.com", "0455555555");
        System.out.println(UserList.getUser(0).showAll());
        assertEquals(expected, UserList.getUser(0).showAll().toString());
    }

}
