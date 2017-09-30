package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class AvailableMovies {

    private static List<Movie> availableMovies = new ArrayList<Movie>();

    public static Movie getAvailableMovie(int index){
        return availableMovies.get(index);
    }

    public static void addAvailableMovie(Movie movie) {
        availableMovies.add(movie);
    }

    public static void checkMovieIsAvailableToBorrow(String name) {
        int index = getIndexByNameInAvailable(name);
        if (index >= 0) {
            Movie toBorrow = getAvailableMovie(index);
            checkoutMovie(toBorrow);
        } else {
            System.out.println("That movie is not available.");
        }
    }

    public static void selectMovieToBorrow() {
        System.out.println("To borrow, please input the movies name\n");
        String nameInput = BibliotecaApp.readInput();
        checkMovieIsAvailableToBorrow(nameInput);
    }

    public static int getIndexByNameInAvailable(String name) {
        for(Movie x: availableMovies) {
            if(x.getName().equals(name))   {
                return availableMovies.indexOf(x);
            }
        }
        return -1;
    }

    public static void deleteAllAvailableMovies() {
        availableMovies.clear();
    }

    
    public static void getAllAvailableMovies() {
        System.out.println("Available Movies:\n");
        System.out.printf("%-20s%-20s%-20s%-20s", "Name", "Year", "Director", "Movie Rating");
        System.out.println("--------------------------------------------------");
        for (Movie x : availableMovies) {
            System.out.println(x.showAll());
        }
        System.out.println("--------------------------------------------------");
    }

    public static void checkoutMovie(Movie movie) {
        try {
            CheckedOutMovies.addCheckedOutMovie(movie);
            availableMovies.remove(movie);
            System.out.println("Thank you! Enjoy the movie.");
        } catch (Exception e) {
            System.out.println("That movie is not available.");
        }
    }

    public static int availableMovieListSize() {
        return availableMovies.size();
    }


}
