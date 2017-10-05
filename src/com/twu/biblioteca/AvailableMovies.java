package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class AvailableMovies {

    private List<Movie> availableMovies = new ArrayList<Movie>();
    private CheckedOutMovies checkedOutMovies;

    public void setCheckedOutMovies(CheckedOutMovies checkedOutMovies){
        this.checkedOutMovies = checkedOutMovies;
    }

    public Movie getAvailableMovie(int index){
        return availableMovies.get(index);
    }

    public void addAvailableMovie(Movie movie) {
        availableMovies.add(movie);
    }

    public void checkMovieIsAvailableToBorrow(String title, User activeUser) {
        int index = getIndexByTitleInAvailable(title);
        if (index >= 0) {
            Movie toBorrow = getAvailableMovie(index);
            checkoutMovie(toBorrow, activeUser);
        } else {
            System.out.println("That movie is not available.");
        }
    }

    public int getIndexByTitleInAvailable(String title) {
        for(Movie x: availableMovies) {
            if(x.getTitle().equals(title))   {
                return availableMovies.indexOf(x);
            }
        }
        return -1;
    }

    public void deleteAllAvailableMovies() {
        availableMovies.clear();
    }

    
    public void getAllAvailableMovies() {
        System.out.println("Available Movies:\n");
        System.out.printf("%-30s%-20s%-30s%-20s", "Title", "Year", "Director", "Movie Rating");
        System.out.println("\n--------------------------------------------------------------------------------------------------");
        for (Movie x : availableMovies) {
            System.out.println(x.showAll());
        }
        System.out.println("--------------------------------------------------------------------------------------------------");
    }

    public void checkoutMovie(Movie movie, User activeUser) {
        try {
            checkedOutMovies.addCheckedOutMovie(movie);
            availableMovies.remove(movie);
            activeUser.addCheckedOutMovie(movie);
            System.out.println("Thank you! Enjoy the movie.");
        } catch (Exception e) {
            System.out.println("That movie is not available.");
        }
    }

    public int availableMovieListSize() {
        return availableMovies.size();
    }


}
