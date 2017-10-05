package com.twu.biblioteca;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {

    AvailableBooks availableBooks = new AvailableBooks();
    CheckedOutBooks checkedOutBooks = new CheckedOutBooks();

    @BeforeClass
    public void initialSetup() {
        availableBooks.setCheckedOutBooks(checkedOutBooks);
        checkedOutBooks.setAvailableBooks(availableBooks);
    }

    Book test = new Book("Game of Thrones", "Bob", 1900);

    @Before
    public void setup() {
        availableBooks.addAvailableBook(test);
        //availableBooks.addAvailableBook(new Book("Game of Thrones", "Bob", 1900);
    }

    @Test
    public void testGetTitle() {
        assertEquals("Game of Thrones", test.getTitle());
    }

    @Test
    public void testGetAuthor() {
        assertEquals("Bob", test.getAuthor());
    }

    @Test
    public void testGetYear() {
        assertEquals(1900, test.getYear());
    }

    @Test
    public void testShowAll() {
        String expected = String.format("%-30s%-30s%-20s", "Game of Thrones", "Bob", 1900);
        assertEquals(expected, test.showAll());
    }

    @Test
    public void testSetTitle() {
        test.setTitle("Lala");
        assertEquals("Lala", test.getTitle());
    }

    @Test
    public void testSetAuthor() {
        test.setAuthor("George Washington");
        assertEquals("George Washington", test.getAuthor());
    }

    @Test
    public void testSetYear() {
        test.setYear(1000);
        assertEquals(1000, test.getYear());
    }


}



