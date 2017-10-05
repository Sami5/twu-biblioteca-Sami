package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckedOutMoviesTest {

    AvailableMovies availableMovies = new AvailableMovies();
    CheckedOutMovies checkedOutMovies = new CheckedOutMovies();

    @BeforeClass
    public void initialSetup() {
        availableMovies.setCheckedOutMovies(checkedOutMovies);
        checkedOutMovies.setAvailableMovies(availableMovies);
    }

    @Before
    public void setup() {
        availableMovies.addAvailableMovie(new Movie("Titanic", 1997, "James Cameron", 10));
        availableMovies.addAvailableMovie(new Movie("Alien", 1980, "John Smith", 8));
        availableMovies.addAvailableMovie(new Movie("The Matrix", 1999, "Dracula", 9));
    }

    @After
    public void tearDown() {
        availableMovies.deleteAllAvailableMovies();
        checkedOutMovies.deleteAllCheckedOutMovies();
    }

    @Test
    public void testReturnMovie() {
        availableMovies.deleteAllAvailableMovies();
        checkedOutMovies.deleteAllCheckedOutMovies();

        Movie movie1 = new Movie("Titanic", 1997, "James Cameron", 10);
        Movie movie2 = new Movie("Alien", 1980, "John Smith", 8);

        availableMovies.checkoutMovie(movie2);

        checkedOutMovies.returnMovie(movie2);

        assertEquals(2, availableMovies.availableMovieListSize());
        assertEquals(0, checkedOutMovies.checkedOutMovieListSize());

    }

    @Test
    public void testGetIndexByName_ShouldReturnIndex_WhereMovieFound() {
        Movie movie1 = new Movie("Titanic", 1997, "James Cameron", 10);

        availableMovies.checkoutMovie(movie1);

        assertEquals(0, checkedOutMovies.getIndexByNameInCheckedOut("Titanic"));
    }

    @Test
    public void testGetIndexByName_ShouldReturnMinusOne_WhereMovieNotFound() {
        assertEquals(-1, checkedOutMovies.getIndexByNameInCheckedOut("Howdy"));
    }

}
