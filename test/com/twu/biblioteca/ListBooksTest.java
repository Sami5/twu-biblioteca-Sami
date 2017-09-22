package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListBooksTest {

    @Before
    public void setup() {
        Book test1 = new Book("Game of Thrones", "Bob", 1900);
        Book test2 = new Book("Lord of the Rings", "John", 1950);
        Book test3 = new Book("Harry Potter", "Victoria", 1857);
    }

    @After
    public void tearDown() {
        ListBooks.deleteAllAvailableBooks();
    }

    @Test
    public void testGetAvailableBook() {
        assertEquals("Title: Game of Thrones, Author: Bob, Year: 1900", ListBooks.getAvailableBook(0).toString());
    }

    @Test
    public void testAvailableBookListSize() {
        assertEquals(3, ListBooks.availableBookListSize());
    }

    @Test
    public void testCheckoutBook() {
        ListBooks.deleteAllAvailableBooks();
        Book test1 = new Book("Game of Thrones", "Bob", 1900);
        Book test2 = new Book("Lord of the Rings", "John", 1950);
        Book test3 = new Book("Harry Potter", "Victoria", 1857);

        ListBooks.checkoutBook(test3);
        assertEquals(2, ListBooks.availableBookListSize());
        assertEquals(1, ListBooks.checkedOutBookListSize());

        ListBooks.returnBook(test3);
        assertEquals(3, ListBooks.availableBookListSize());
        assertEquals(0, ListBooks.checkedOutBookListSize());
    }

    @Test
    public void testGetIndexByTitle() {
        assertEquals(1, ListBooks.getIndexByTitle("Lord of the Rings"));
    }

    @Test
    public void testFindAvailableBookByTitle() {
        assertEquals("Title: Lord of the Rings, Author: John, Year: 1950", ListBooks.findAvailableBookByTitle(1).toString());
    }

}
