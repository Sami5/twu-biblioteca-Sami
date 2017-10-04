package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu {

    private AvailableBooks availableBooks;
    private AvailableMovies availableMovies;
    private CheckedOutBooks checkedOutBooks;
    private CheckedOutMovies checkedOutMovies;
    private UserList userList;

    public MainMenu(AvailableBooks availableBooks, AvailableMovies availableMovies, CheckedOutBooks checkedOutBooks, CheckedOutMovies checkedOutMovies, UserList userList) {
        this.availableBooks = availableBooks;
        this.availableMovies = availableMovies;
        this.checkedOutBooks = checkedOutBooks;
        this.checkedOutMovies = checkedOutMovies;
        this.userList = userList;
    }

    public String readInput() {
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        System.out.print("\nPlease enter input: \n");
        String input = scan.next();
        //scan.close();
        System.out.println("");
        return input;
    }

    public void chooseMainMenuItem() {
        System.out.println("\nPlease make a menu selection.");
        System.out.println("\n- List Books \n- List Movies \n- Quit");

        String input = readInput().toLowerCase();

        switch(input) {
            case "list books":
                System.out.println("\nList Books selected");
                availableBooks.getAllAvailableBooks();
                bookNavigation();
                break;
            case "list movies":
                System.out.println("\nList Movies selected");
                availableMovies.getAllAvailableMovies();
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

    public void movieNavigation() {
        System.out.println("\nWhat would you like to do next?");
        System.out.println("\n- List Movies \n- Borrow Movie \n- Return Movie \n- Back \n- Quit");

        String input = readInput().toLowerCase();

        switch(input) {
            case "list movies":
                availableMovies.getAllAvailableMovies();
                movieNavigation();
                break;
            case "borrow movie":
                System.out.println("To borrow, please input the movies title\n");
                String titleInputBorrow = readInput();
                availableMovies.checkMovieIsAvailableToBorrow(titleInputBorrow);
                movieNavigation();
                break;
            case "return movie":
                System.out.println("To return, please input the movies title\n");
                String titleInputReturn = readInput();
                checkedOutMovies.checkMovieIsValidReturn(titleInputReturn);
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

    public void bookNavigation() {
        System.out.println("\nWhat would you like to do next?");
        System.out.println("\n- List Books \n- Borrow Book \n- Return Book \n- Back \n- Quit");

        String input = readInput().toLowerCase();

        switch(input) {
            case "list books":
                availableBooks.getAllAvailableBooks();
                bookNavigation();
                break;
            case "borrow book":
                System.out.println("To borrow, please input the books title\n");
                String titleInputBorrow = readInput();
                availableBooks.checkBookIsAvailableToBorrow(titleInputBorrow);
                bookNavigation();
                break;
            case "return book":
                System.out.println("To return, please input the books title\n");
                String titleInputReturn = readInput();
                checkedOutBooks.checkBookIsValidReturn(titleInputReturn);
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
