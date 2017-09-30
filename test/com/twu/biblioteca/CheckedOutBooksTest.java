package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckedOutBooksTest {

    @Before
    public void setup() {
        Book test1 = new Book("Game of Thrones", "Bob", 1900);
        Book test2 = new Book("Lord of the Rings", "John", 1950);
        Book test3 = new Book("Harry Potter", "Victoria", 1857);
    }

    @After
    public void tearDown() {
        AvailableBooks.deleteAllAvailableBooks();
        CheckedOutBooks.deleteAllCheckedOutBooks();
    }

    @Test
    public void testReturnBook() {
        AvailableBooks.deleteAllAvailableBooks();
        CheckedOutBooks.deleteAllCheckedOutBooks();

        Book book1 = new Book("Game of Thrones", "Bob", 1900);
        Book book2 = new Book("Lord of the Rings", "John", 1950);

        AvailableBooks.checkoutBook(book2);

        CheckedOutBooks.returnBook(book2);

        assertEquals(2, AvailableBooks.availableBookListSize());
        assertEquals(0, CheckedOutBooks.checkedOutBookListSize());

    }



}
