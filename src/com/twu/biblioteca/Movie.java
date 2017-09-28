package com.twu.biblioteca;

public class Movie {

    private String name;
    private int year;
    private String director;
    private int movieRating;

    public Movie(String newName, int newYear, String newDirector, int newMovieRating){
        name = newName;
        year = newYear;
        director = newDirector;
        movieRating = newMovieRating;

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

    public int getMovieRating() {
        return movieRating;
    }


    public String showAll() {
        String name = this.getName();
        int year = this.getYear();
        String director = this.getDirector();
        int movieRating = this.getMovieRating();

        String details = String.format("%-20s%-20s%-20s%-20s", name, year, director, movieRating);
        return details;

    }
}
