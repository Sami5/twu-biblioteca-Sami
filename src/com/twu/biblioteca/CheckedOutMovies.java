package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class CheckedOutMovies {

    private static List<Movie> checkedOutMovies = new ArrayList<Movie>();

    public static Movie getCheckedOutMovie(int element) {
        return checkedOutMovies.get(element);
    }

    public static void addCheckedOutMovie(Movie movie) {
        checkedOutMovies.add(movie);
    }

    public static void checkMovieIsValidReturn(String name) {
        int index = getIndexByNameInCheckedOut(name);
        if (index >= 0) {
            Movie toReturn = getCheckedOutMovie(index);
            returnMovie(toReturn);
        } else {
            System.out.println("That is not a valid movie to return.");
        }
    }

    public static void selectMovieToReturn() {
        System.out.println("To return, please input the movies name\n");
        String nameInput = MainMenu.readInput();
        checkMovieIsValidReturn(nameInput);
    }

    public static int getIndexByNameInCheckedOut(String name) {
        for (Movie x : checkedOutMovies) {
            if (x.getName().equals(name)) {
                return checkedOutMovies.indexOf(x);
            }
        }
        return -1;
    }

    public static void returnMovie(Movie movie) {
        try {
            AvailableMovies.addAvailableMovie(movie);
            checkedOutMovies.remove(movie);
            System.out.println("Thank you for returning the movie.");
        } catch (Exception e) {
            System.out.println("That is not a valid movie to return.");
        }
    }

    public static void getAllCheckedOutMovies() {
        System.out.println("Checked Out Movies:\n");
        System.out.printf("%-30s%-20s%-30s%-20s", "Name", "Year", "Director", "Movie Rating");
        System.out.println("--------------------------------------------------------------------------------------------------");
        for (Movie x : checkedOutMovies) {
            System.out.println(x.showAll());
        }
        System.out.println("--------------------------------------------------------------------------------------------------");
    }


    public static int checkedOutMovieListSize() {
        return checkedOutMovies.size();
    }


    public static void deleteAllCheckedOutMovies() {
        checkedOutMovies.clear();
    }



}
