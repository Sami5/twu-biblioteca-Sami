package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {

    Book test = new Book("Game of Thrones", "Bob", 1900);

    @Test
    public void testBookTitle() {
        assertEquals("Game of Thrones", test.getTitle());
    }

    @Test
    public void testBookAuthor() {
        assertEquals("Bob", test.getAuthor());
    }

    @Test
    public void testBookYear() {
        assertEquals(1900, test.getYear());
    }


}
