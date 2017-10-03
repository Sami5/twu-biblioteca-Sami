package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu {

    public static String readInput() {
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        System.out.print("\nPlease enter input: \n");
        String input = scan.next();
        //scan.close();
        System.out.println("");
        return input;
    }

    public static void chooseMainMenuItem() {
        System.out.println("\nPlease make a menu selection.");
        System.out.println("\n- List Books \n- List Movies \n- Quit");

        String input = readInput().toLowerCase();

        switch(input) {
            case "list books":
                System.out.println("\nList Books selected");
                AvailableBooks.getAllAvailableBooks();
                bookNavigation();
                break;
            case "list movies":
                System.out.println("\nList Movies selected");
                AvailableMovies.getAllAvailableMovies();
                movieNavigation();
                break;
            case "quit":
                System.out.println("\nExiting Program");
                break;
            default:
                System.out.println("\nSelect a valid option!");
                chooseMainMenuItem();
        }
    }

    public static void movieNavigation() {
        System.out.println("\nWhat would you like to do next?");
        System.out.println("\n- List Movies \n- Borrow Movie \n- Return Movie \n- Back \n- Quit");

        String input = readInput().toLowerCase();

        switch(input) {
            case "list movies":
                AvailableMovies.getAllAvailableMovies();
                movieNavigation();
                break;
            case "borrow movie":
                AvailableMovies.selectMovieToBorrow();
                movieNavigation();
                break;
            case "return movie":
                CheckedOutMovies.selectMovieToReturn();
                movieNavigation();
                break;
            case "back":
                System.out.println("\nBack to Main Menu");
                chooseMainMenuItem();
                break;
            case "quit":
                System.out.println("\nExiting Program");
                break;
            default:
                System.out.println("\nSelect a valid option!");
                movieNavigation();
        }

    }

    public static void bookNavigation() {
        System.out.println("\nWhat would you like to do next?");
        System.out.println("\n- List Books \n- Borrow Book \n- Return Book \n- Back \n- Quit");

        String input = readInput().toLowerCase();

        switch(input) {
            case "list books":
                AvailableBooks.getAllAvailableBooks();
                bookNavigation();
                break;
            case "borrow book":
                AvailableBooks.selectBookToBorrow();
                bookNavigation();
                break;
            case "return book":
                CheckedOutBooks.selectBookToReturn();
                bookNavigation();
                break;
            case "back":
                System.out.println("\nBack to Main Menu");
                chooseMainMenuItem();
                break;
            case "quit":
                System.out.println("\nExiting Program");
                break;
            default:
                System.out.println("\nSelect a valid option!");
                bookNavigation();
        }

    }

}
