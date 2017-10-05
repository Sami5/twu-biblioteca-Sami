package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class CheckedOutMovies {

    private List<Movie> checkedOutMovies = new ArrayList<Movie>();
    private AvailableMovies availableMovies;

    public void setAvailableMovies(AvailableMovies availableMovies){
        this.availableMovies = availableMovies;
    }

    public Movie getCheckedOutMovie(int element) {
        return checkedOutMovies.get(element);
    }

    public void addCheckedOutMovie(Movie movie) {
        checkedOutMovies.add(movie);
    }

    public void checkMovieIsValidReturn(String name, User activeUser) {
        int index = getIndexByNameInCheckedOut(name);
        if (index >= 0) {
            Movie toReturn = getCheckedOutMovie(index);
            returnMovie(toReturn, activeUser);
        } else {
            System.out.println("That is not a valid movie to return.");
        }
    }

    public int getIndexByNameInCheckedOut(String name) {
        for (Movie x : checkedOutMovies) {
            if (x.getTitle().equals(name)) {
                return checkedOutMovies.indexOf(x);
            }
        }
        return -1;
    }

    public void returnMovie(Movie movie, User activeUser) {
        try {
            availableMovies.addAvailableMovie(movie);
            checkedOutMovies.remove(movie);
            activeUser.removeCheckedOutMovie(movie);
            System.out.println("Thank you for returning the movie.");
        } catch (Exception e) {
            System.out.println("That is not a valid movie to return.");
        }
    }

    public void getAllCheckedOutMovies() {
        System.out.println("Checked Out Movies:\n");
        System.out.printf("%-30s%-20s%-30s%-20s", "Name", "Year", "Director", "Movie Rating");
        System.out.println("--------------------------------------------------------------------------------------------------");
        for (Movie x : checkedOutMovies) {
            System.out.println(x.showAll());
        }
        System.out.println("--------------------------------------------------------------------------------------------------");
    }


    public int checkedOutMovieListSize() {
        return checkedOutMovies.size();
    }


    public void deleteAllCheckedOutMovies() {
        checkedOutMovies.clear();
    }



}
