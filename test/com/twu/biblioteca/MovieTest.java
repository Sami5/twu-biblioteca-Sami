package com.twu.biblioteca;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MovieTest {

    AvailableMovies availableMovies = new AvailableMovies();
    CheckedOutMovies checkedOutMovies = new CheckedOutMovies();

    @BeforeClass
    public void initialSetup() {
        availableMovies.setCheckedOutMovies(checkedOutMovies);
        checkedOutMovies.setAvailableMovies(availableMovies);
    }

    Movie allValidParams = new Movie("Titanic", 1997, "James Cameron", 10);
    Movie invalidMovieRating = new Movie("Planet of the Apes", 1500, "Nicole", 15);
    Movie noMovieRating = new Movie("The Matrix", 1500, "James");

    @Before
    public void setup() {
        availableMovies.addAvailableMovie(allValidParams);
        availableMovies.addAvailableMovie(invalidMovieRating);
        availableMovies.addAvailableMovie(noMovieRating);
    }

    @Test
    public void testGetName() {
        assertEquals("Titanic", allValidParams.getTitle());
    }

    @Test
    public void testGetYear() {
        assertEquals(1997, allValidParams.getYear());
    }

    @Test
    public void testGetDirector() {
        assertEquals("James Cameron", allValidParams.getDirector());
    }

    @Test
    public void testGetMovieRating() {
        assertEquals(String.valueOf(10), allValidParams.getMovieRating());
    }

    @Test
    public void testSetName(){
        allValidParams.setTitle("Alien");
        assertEquals("Alien", allValidParams.getTitle());
    }

    @Test
    public void testSetYear() {
        allValidParams.setYear(500);
        assertEquals(500, allValidParams.getYear());
    }

    @Test
    public void testSetDirector() {
        allValidParams.setDirector("Cleopatra");
        assertEquals("Cleopatra", allValidParams.getDirector());
    }

    @Test
    public void testSetMovieRating() {

        allValidParams.setMovieRating(5);
        assertEquals(String.valueOf(5), allValidParams.getMovieRating());
/*
        invalidMovieRating.setMovieRating(15);
        assertEquals(new IllegalArgumentException("Invalid movie rating"), invalidMovieRating.getMovieRating());
*/
        allValidParams.setMovieRating();
        assertEquals("unrated", allValidParams.getMovieRating());

    }


    @Test
    public void testShowAll() {
        String expected = String.format("%-30s%-20s%-30s%-20s", "Titanic", 1997, "James Cameron", "10");
        assertEquals(expected, allValidParams.showAll());
    }



}
