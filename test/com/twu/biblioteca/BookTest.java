package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {

    Book test = new Book("Game of Thrones", "Bob", 1900);

    @Test
    public void testGetTitle() {
        assertEquals("Game of Thrones", test.getTitle());
    }

    @Test
    public void testGetAuthor() {
        assertEquals("Bob", test.getAuthor());
    }

    @Test
    public void testGetYear() {
        assertEquals(1900, test.getYear());
    }

    @Test
    public void testShowAll() {
        String expected = String.format("%-20s%-20s%-20s", "Game of Thrones", "Bob", 1900);
        assertEquals(expected, test.showAll());
    }

}
