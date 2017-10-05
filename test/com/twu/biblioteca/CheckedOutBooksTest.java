package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckedOutBooksTest {

    AvailableBooks availableBooks = new AvailableBooks();
    CheckedOutBooks checkedOutBooks = new CheckedOutBooks();

    @BeforeClass
    public void initialSetup() {
        availableBooks.setCheckedOutBooks(checkedOutBooks);
        checkedOutBooks.setAvailableBooks(availableBooks);
    }

    @Before
    public void setup() {
        availableBooks.addAvailableBook(new Book("Game of Thrones", "Bob", 1900));
        availableBooks.addAvailableBook(new Book("Lord of the Rings", "John", 1950));
        availableBooks.addAvailableBook(new Book("Harry Potter", "Victoria", 1857));
    }

    @After
    public void tearDown() {
        availableBooks.deleteAllAvailableBooks();
        checkedOutBooks.deleteAllCheckedOutBooks();
    }

    @Test
    public void testReturnBook() {
        availableBooks.deleteAllAvailableBooks();
        checkedOutBooks.deleteAllCheckedOutBooks();

        Book book1 = new Book("Game of Thrones", "Bob", 1900);
        Book book2 = new Book("Lord of the Rings", "John", 1950);

        availableBooks.checkoutBook(book2);

        checkedOutBooks.returnBook(book2);

        assertEquals(2, availableBooks.availableBookListSize());
        assertEquals(0, checkedOutBooks.checkedOutBookListSize());

    }

    @Test
    public void testGetIndexByTitle_ShouldReturnIndex_WhereBookFound() {
        Book test2 = new Book("Lord of the Rings", "John", 1950);

        availableBooks.checkoutBook(test2);

        assertEquals(0, checkedOutBooks.getIndexByTitleInCheckedOut("Lord of the Rings"));
    }

    @Test
    public void testGetIndexByTitle_ShouldReturnMinusOne_WhereBookNotFound() {
        assertEquals(-1, checkedOutBooks.getIndexByTitleInCheckedOut("Ford of the Rings"));
    }



}
