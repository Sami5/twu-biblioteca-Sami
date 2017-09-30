package com.twu.biblioteca;

public class Movie {

    private String name;
    private int year;
    private String director;
    private String movieRating;

    public Movie(String newName, int newYear, String newDirector, int newMovieRating) {
        if (newMovieRating > 0 && newMovieRating <= 10) {
            setName(newName);
            setYear(newYear);
            setDirector(newDirector);
            setMovieRating(newMovieRating);

            AvailableMovies.addAvailableMovie(this);

        } else {
            throw new IllegalArgumentException("Invalid movie rating");
        }
    }

    public Movie(String newName, int newYear, String newDirector) {
        setName(newName);
        setYear(newYear);
        setDirector(newDirector);
        setMovieRating();

        AvailableMovies.addAvailableMovie(this);
    }


    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setYear(int newYear) {
        year = newYear;
    }

    public void setDirector(String newDirector) {
        director = newDirector;
    }

    public void setMovieRating(int newMovieRating) {
        movieRating = String.valueOf(newMovieRating);
    }

    public void setMovieRating() {
        movieRating = "unrated";
    }


    public String showAll() {
        String name = this.getName();
        int year = this.getYear();
        String director = this.getDirector();
        String movieRating = this.getMovieRating();

        String details = String.format("%-30s%-20s%-30s%-20s", name, year, director, movieRating);
        return details;

    }
}
