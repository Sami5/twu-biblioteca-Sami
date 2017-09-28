package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MovieTest {

    Movie test = new Movie("Titanic", 1997, "James Cameron", 10);

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
        assertEquals(10, test.getMovieRating());
    }

    @Test
    public void testSetName(){
        test.setName("Alien");
        assertEquals("Alien", test.getName());
    }

    @Test
    public void testSetYear() {
        test.setYear(500);
        assertEquals(500, test.getYear());
    }

    @Test
    public void testSetDirector() {
        test.setDirector("Cleopatra");
        assertEquals("Cleopatra", test.getDirector());
    }

    @Test
    public void testSetMovieRating() {
        test.setMovieRating(5);
        assertEquals(5, test.getMovieRating());
    }

    @Test
    public void testShowAll() {
        String expected = String.format("%-20s%-20s%-20s%-20s", "Titanic", 1997, "James Cameron", 10);
        assertEquals(expected, test.showAll());
    }



}
