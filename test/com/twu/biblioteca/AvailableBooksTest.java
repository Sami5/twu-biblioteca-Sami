package com.twu.biblioteca;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class AvailableBooksTest {

    AvailableBooks availableBooks;
    CheckedOutBooks checkedOutBooks;

    @Before
    public void setup() {
        availableBooks = new AvailableBooks();
        checkedOutBooks = new CheckedOutBooks();

        availableBooks.setCheckedOutBooks(checkedOutBooks);
        checkedOutBooks.setAvailableBooks(availableBooks);

        availableBooks.addAvailableBook(new Book("Game of Thrones", "Bob", 1900));
        availableBooks.addAvailableBook(new Book("Lord of the Rings", "John", 1950));
        availableBooks.addAvailableBook(new Book("Harry Potter", "Victoria", 1857));
    }

    @Test
    public void testGetAvailableBook() {
        String expected = String.format("%-30s%-30s%-20s", "Game of Thrones", "Bob", "1900");
        assertEquals(expected, availableBooks.getAvailableBook(0).showAll().toString());
    }

    @Test
    public void testAvailableBookListSize() {
        assertEquals(3, availableBooks.availableBookListSize());
    }

    @Test
    public void testCheckoutBook() {
        availableBooks.deleteAllAvailableBooks();

        Book book1 = new Book("Game of Thrones", "Bob", 1900);
        Book book2 = new Book("Lord of the Rings", "John", 1950);
        availableBooks.addAvailableBook(book1);
        availableBooks.addAvailableBook(book2);

        availableBooks.checkoutBook(book2);

        assertEquals(1, availableBooks.availableBookListSize());
        assertEquals(1, checkedOutBooks.checkedOutBookListSize());
    }

    @Test
    public void testGetIndexByTitle_ShouldReturnIndex_WhereBookFound() {
        assertEquals(1, availableBooks.getIndexByTitleInAvailable("Lord of the Rings"));
    }

    @Test
    public void testGetIndexByTitle_ShouldReturnMinusOne_WhereBookNotFound() {
        assertEquals(-1, availableBooks.getIndexByTitleInAvailable("Ford of the Rings"));
    }

    @Test
    public void testFindAvailableBookByTitle() {
        String expected = String.format("%-30s%-30s%-20s", "Lord of the Rings", "John", "1950");
        assertEquals(expected, availableBooks.getAvailableBook(1).showAll().toString());
    }

}
