package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckedOutBooksTest {

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
        User activeUser = new User("243-9405", "fsl5", "Nicole Jones", "nicole@hotmail.com", "0455555555");

        checkedOutBooks.addCheckedOutBook(book1);
        checkedOutBooks.addCheckedOutBook(book2);

        checkedOutBooks.returnBook(book2, activeUser);

        assertEquals(1, availableBooks.availableBookListSize());
        assertEquals(1, checkedOutBooks.checkedOutBookListSize());
        assertEquals(0, activeUser.checkedOutBooksListSize());

    }

    @Test
    public void testGetIndexByTitle_ShouldReturnIndex_WhereBookFound() {
        Book test = new Book("Lord of the Rings", "John", 1950);
        User activeUser = new User("243-9405", "fsl5", "Nicole Jones", "nicole@hotmail.com", "0455555555");

        availableBooks.checkoutBook(test, activeUser);

        assertEquals(0, checkedOutBooks.getIndexByTitleInCheckedOut("Lord of the Rings"));
    }

    @Test
    public void testGetIndexByTitle_ShouldReturnMinusOne_WhereBookNotFound() {
        assertEquals(-1, checkedOutBooks.getIndexByTitleInCheckedOut("Ford of the Rings"));
    }



}
