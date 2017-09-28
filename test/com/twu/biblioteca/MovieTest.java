package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MovieTest {

    Movie test = new Movie("Titanic", 1997, "James Cameron", 5);

    @Test
    public void testGetName() {
        assertEquals("Titanic", test.getName());
    }

    @Test
    public void testGetYear() {
        assertEquals(1997, test.getYear());
    }

    @Test
    public void testGetDirector() {
        assertEquals("James Cameron", test.getDirector());
    }

    @Test
    public void testGetMovieRating() {
        assertEquals(5, test.getMovieRating());
    }

    @Test
    public void testShowAll() {
        String expected = String.format("%-20s%-20s%-20s%-20s", "Titanic", 1997, "James Cameron", 5);
        assertEquals(expected, test.showAll());
    }



}
