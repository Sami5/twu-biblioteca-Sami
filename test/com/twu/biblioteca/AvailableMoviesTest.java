package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AvailableMoviesTest {

    @Before
    public void setup() {
        Movie test1 = new Movie("Titanic", 1997, "James Cameron", 10);
        Movie test2 = new Movie("Alien", 1980, "John Smith", 8);
        Movie test3 = new Movie("The Matrix", 1999, "Dracula", 9);
    }

    @After
    public void tearDown() {
        AvailableMovies.deleteAllAvailableMovies();
        CheckedOutMovies.deleteAllCheckedOutMovies();
    }

    @Test
    public void testGetAvailableMovie() {
        String expected = String.format("%-20s%-20s%-20s%-20s", "Titanic", 1997, "James Cameron", 10);
        assertEquals(expected, AvailableMovies.getAvailableMovie(0).showAll().toString());
    }

    @Test
    public void testAvailableMovieListSize() { assertEquals(3, AvailableMovies.availableMovieListSize());}

    @Test
    public void testCheckoutMovie() {
        AvailableMovies.deleteAllAvailableMovies();

        Movie movie1 = new Movie("Titanic", 1997, "James Cameron", 10);
        Movie movie2 = new Movie("Alien", 1980, "John Smith", 8);

        AvailableMovies.checkoutMovie(movie2);

        assertEquals(1, AvailableMovies.availableMovieListSize());
        assertEquals(1, CheckedOutMovies.checkedOutMovieListSize());
    }

    @Test
    public void testGetIndexByName_ShouldReturnIndex_WhereMovieFound() {
        assertEquals(1, AvailableMovies.getIndexByNameInAvailable("Alien"));
    }

    @Test
    public void testGetIndexByName_ShouldReturnMinusOne_WhereMovieNotFound() {
        assertEquals(-1, AvailableMovies.getIndexByNameInAvailable("Howdy"));
    }

    @Test
    public void testFindAvailableMovieByName() {
        String expected = String.format("%-20s%-20s%-20s%-20s", "Alien", 1980, "John Smith", 8);
        assertEquals(expected, AvailableMovies.getAvailableMovie(1).showAll().toString());
    }


}
