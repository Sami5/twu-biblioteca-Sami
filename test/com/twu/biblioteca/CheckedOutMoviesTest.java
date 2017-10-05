package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckedOutMoviesTest {

    AvailableMovies availableMovies;
    CheckedOutMovies checkedOutMovies;

    @Before
    public void setup() {

        availableMovies = new AvailableMovies();
        checkedOutMovies = new CheckedOutMovies();

        availableMovies.setCheckedOutMovies(checkedOutMovies);
        checkedOutMovies.setAvailableMovies(availableMovies);

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

        Movie movie = new Movie("Titanic", 1997, "James Cameron", 10);
        User activeUser = new User("243-9405", "fsl5", "Nicole Jones", "nicole@hotmail.com", "0455555555");

        checkedOutMovies.addCheckedOutMovie(movie);
        checkedOutMovies.returnMovie(movie, activeUser);

        assertEquals(1, availableMovies.availableMovieListSize());
        assertEquals(0, checkedOutMovies.checkedOutMovieListSize());
        assertEquals(0, activeUser.checkedOutMoviesListSize());

    }

    @Test
    public void testGetIndexByName_ShouldReturnIndex_WhereMovieFound() {
        Movie movie1 = new Movie("Titanic", 1997, "James Cameron", 10);
        User activeUser = new User("243-9405", "fsl5", "Nicole Jones", "nicole@hotmail.com", "0455555555");

        availableMovies.checkoutMovie(movie1, activeUser);

        assertEquals(0, checkedOutMovies.getIndexByNameInCheckedOut("Titanic"));
    }

    @Test
    public void testGetIndexByName_ShouldReturnMinusOne_WhereMovieNotFound() {
        assertEquals(-1, checkedOutMovies.getIndexByNameInCheckedOut("Howdy"));
    }

}
