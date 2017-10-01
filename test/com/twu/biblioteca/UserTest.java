package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class UserTest {

    User minParams = new User("389-2904", "ksfh389");
    User allParams = new User("389-2893", "jfs0930", "Nicole Jones", "nicole@hotmail.com", 0455555555);

    @Test
    public void testShowAll_ShouldReturnString_WhereMinParamsEntered() {
        String expected = String.format("%-30s%-30s%-30s%-30s%-20s", "389-2904", "ksfh389", null, null, 0);
        assertEquals(expected, minParams.showAll());
    }

    @Test
    public void testShowAll_ShouldReturnString_WhereAllParamsEntered() {
        String expected = String.format("%-30s%-30s%-30s%-30s%-20s", "389-2893", "jfs0930", "Nicole Jones", "nicole@hotmail.com", 0455555555);
        assertEquals(expected, allParams.showAll());
    }


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

    @Test
    public void testLibraryNumberFormatRegex_ShouldReturnTrue_WhereInputValid() {
        assertTrue("389-3890".matches("\\b\\d{3,3}\\-\\d{4,4}$"));
    }

    @Test
    public void testLibraryNumberFormatRegex_ShouldReturnFalse_WhereInputInvalid1() {
        assertFalse("389-38590".matches("\\b\\d{3,3}\\-\\d{4,4}$"));
    }

    @Test
    public void testLibraryNumberFormatRegex_ShouldReturnFalse_WhereInputInvalid2() {
        assertFalse("3893-3859".matches("\\b\\d{3,3}\\-\\d{4,4}$"));
    }



}
