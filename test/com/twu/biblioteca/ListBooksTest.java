package com.twu.biblioteca;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ListBooksTest {

    @BeforeClass
    public static void oneTimeSetup() {
        Book test1 = new Book("Game of Thrones", "Bob", 1900);
        Book test2 = new Book("Lord of the Rings", "John", 1950);
    }

    @Test
    public void testBookListSize() {
        assertEquals(2, ListBooks.bookListSize());
    }

    @Test
    public void testGetBook() {
        assertEquals("Title: Game of Thrones, Author: Bob, Year: 1900", ListBooks.getBook(0).toString());
    }


}
