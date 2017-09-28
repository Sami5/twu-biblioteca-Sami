package com.twu.biblioteca;

public class Movie {

    private String name;
    private int year;
    private String director;
    private int movieRating;

    public Movie(String newName, int newYear, String newDirector, int newMovieRating){
        setName(newName);
        setYear(newYear);
        setDirector(newDirector);
        setMovieRating(newMovieRating);

    }


    public String getName() { return name; }

    public int getYear() { return year; }

    public String getDirector() { return director; }

    public int getMovieRating() { return movieRating; }

    public void setName(String newName) { name = newName; }

    public void setYear(int newYear) { year = newYear; }

    public void setDirector(String newDirector) {director = newDirector; }

    public void setMovieRating(int newMovieRating) {
        movieRating = newMovieRating;
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
