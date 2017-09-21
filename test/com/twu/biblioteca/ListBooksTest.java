package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ListBooksTest {

    Book test1 = new Book("Game of Thrones", "Bob", 1900);
    Book test2 = new Book("Lord of the Rings", "John", 1950);

    @Test
    public void testBookListSize() {
        assertEquals(2, ListBooks.bookListSize());
    }



}
