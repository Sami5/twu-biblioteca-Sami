package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckedOutMoviesTest {

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
    public void testReturnMovie() {
        AvailableMovies.deleteAllAvailableMovies();
        CheckedOutMovies.deleteAllCheckedOutMovies();

        Movie movie1 = new Movie("Titanic", 1997, "James Cameron", 10);
        Movie movie2 = new Movie("Alien", 1980, "John Smith", 8);

        AvailableMovies.checkoutMovie(movie2);

        CheckedOutMovies.returnMovie(movie2);

        assertEquals(2, AvailableMovies.availableMovieListSize());
        assertEquals(0, CheckedOutMovies.checkedOutMovieListSize());

    }

}
