package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    Book test = new Book("Game of Thrones", "Bob", 1900);

    @Test
    public void bookTitleTest() {
        assertEquals("Game of Thrones", test.getTitle());
    }

    @Test
    public void bookAuthorTest() {
        assertEquals("Bob", test.getAuthor());
    }

    @Test
    public void bookYearTest() {
        assertEquals(1900, test.getYearPublished());
    }


}
