package com.twu.biblioteca;

public class Movie {

    private String title;
    private int year;
    private String director;
    private String movieRating;

    public Movie(String newTitle, int newYear, String newDirector, int newMovieRating) {
        try {
            if (newMovieRating > 0 && newMovieRating <= 10) {
                setTitle(newTitle);
                setYear(newYear);
                setDirector(newDirector);
                setMovieRating(newMovieRating);

                //AvailableMovies.addAvailableMovie(this);

            } else {
                throw new IllegalArgumentException("Invalid movie rating");
            }
        } catch (Exception e){
            System.out.println("Invalid movie rating");
        }
    }

    public Movie(String newTitle, int newYear, String newDirector) {
        setTitle(newTitle);
        setYear(newYear);
        setDirector(newDirector);
        setMovieRating();

        //AvailableMovies.addAvailableMovie(this);
    }


    public String getTitle() {
        return title;
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

    public void setTitle(String newTitle) {
        title = newTitle;
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
        String title = this.getTitle();
        int year = this.getYear();
        String director = this.getDirector();
        String movieRating = this.getMovieRating();

        String details = String.format("%-30s%-20s%-30s%-20s", title, year, director, movieRating);
        return details;

    }
}
