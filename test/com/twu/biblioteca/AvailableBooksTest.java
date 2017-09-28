package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AvailableBooksTest {

    @Before
    public void setup() {
        Book test1 = new Book("Game of Thrones", "Bob", 1900);
        Book test2 = new Book("Lord of the Rings", "John", 1950);
        Book test3 = new Book("Harry Potter", "Victoria", 1857);
    }

    @After
    public void tearDown() {
        AvailableBooks.deleteAllAvailableBooks();
    }

    @Test
    public void testGetAvailableBook() {
        String expected = String.format("%-20s%-20s%-20s", "Game of Thrones", "Bob", "1900");
        assertEquals(expected, AvailableBooks.getAvailableBook(0).showAll().toString());
    }

    @Test
    public void testAvailableBookListSize() {
        assertEquals(3, AvailableBooks.availableBookListSize());
    }

    @Test
    public void testCheckoutAndReturn() {
        AvailableBooks.deleteAllAvailableBooks();
        Book test1 = new Book("Game of Thrones", "Bob", 1900);
        Book test2 = new Book("Lord of the Rings", "John", 1950);
        Book test3 = new Book("Harry Potter", "Victoria", 1857);

        AvailableBooks.checkoutBook(test3);
        assertEquals(2, AvailableBooks.availableBookListSize());
        assertEquals(1, CheckedOutBooks.checkedOutBookListSize());

        CheckedOutBooks.returnBook(test3);
        assertEquals(3, AvailableBooks.availableBookListSize());
        assertEquals(0, CheckedOutBooks.checkedOutBookListSize());
    }

    @Test
    public void testGetIndexByTitle_ShouldReturnIndex_WhereBookFound() {
        assertEquals(1, AvailableBooks.getIndexByTitleInAvailable("Lord of the Rings"));
    }
    
    @Test
    public void testGetIndexByTitle_ShouldReturnMinusOne_WhereBookNotFound() {
        assertEquals(-1, AvailableBooks.getIndexByTitleInAvailable("Ford of the Rings"));
    }

    @Test
    public void testFindAvailableBookByTitle() {
        String expected = String.format("%-20s%-20s%-20s", "Lord of the Rings", "John", "1950");
        assertEquals(expected, AvailableBooks.getAvailableBook(1).showAll().toString());
    }

}
