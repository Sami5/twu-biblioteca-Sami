package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test(expected = IllegalArgumentException.class)
    public void testSetLibraryNumber_ShouldReturnException_WhereInputInvalid() {
        User test = new User("345-2949", "sknf293");
        test.setLibraryNumber("243-69054");
    }

    @Test
    public void testSetLibraryNumber_ShouldReturnString_WhereInputValid() {
        User test = new User("345-2947", "sknf293");
        test.setLibraryNumber("243-6905");
        assertEquals("243-6905", test.getLibraryNumber());
    }


}
