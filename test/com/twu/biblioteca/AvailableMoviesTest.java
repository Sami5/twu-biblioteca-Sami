package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AvailableMoviesTest {

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
    public void testGetAvailableMovie() {
        String expected = String.format("%-30s%-20s%-30s%-20s", "Titanic", 1997, "James Cameron", 10);
        assertEquals(expected, availableMovies.getAvailableMovie(0).showAll().toString());
    }

    @Test
    public void testAvailableMovieListSize() { assertEquals(3, availableMovies.availableMovieListSize());}

    @Test
    public void testCheckoutMovie() {
        availableMovies.deleteAllAvailableMovies();

        Movie movie1 = new Movie("Titanic", 1997, "James Cameron", 10);
        Movie movie2 = new Movie("Alien", 1980, "John Smith", 8);
        User activeUser = new User("243-9405", "fsl5", "Nicole Jones", "nicole@hotmail.com", "0455555555");

        availableMovies.addAvailableMovie(movie1);
        availableMovies.addAvailableMovie(movie2);

        availableMovies.checkoutMovie(movie2, activeUser);

        assertEquals(1, availableMovies.availableMovieListSize());
        assertEquals(1, checkedOutMovies.checkedOutMovieListSize());
        assertEquals(1, activeUser.checkedOutMoviesListSize());
    }

    @Test
    public void testGetIndexByTitleShouldReturnIndex_WhereMovieFound() {
        assertEquals(1, availableMovies.getIndexByTitleInAvailable("Alien"));
    }

    @Test
    public void testGetIndexByTitle_ShouldReturnMinusOne_WhereMovieNotFound() {
        assertEquals(-1, availableMovies.getIndexByTitleInAvailable("Howdy"));
    }

    @Test
    public void testFindAvailableMovieByTitle() {
        String expected = String.format("%-30s%-20s%-30s%-20s", "Alien", 1980, "John Smith", 8);
        assertEquals(expected, availableMovies.getAvailableMovie(1).showAll().toString());
    }


}
