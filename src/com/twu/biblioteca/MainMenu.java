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

    public void login() {
        System.out.println("\nPlease login to your account");
        System.out.println("\nPlease enter your library number");
        String libraryNumberInput = readInput();
        System.out.println("\nPlease enter your password");
        String passwordInput = readInput();
        int index = userList.getIndexByLibraryNumberInUsers(libraryNumberInput);

        if (index >= 0 && userList.getUser(index).getPassword().equals(passwordInput)) {
            User activeUser = userList.getUser(index);
            System.out.println("\nWelcome " + activeUser.getName());
            chooseMainMenuItem(activeUser);
        } else {
            System.out.println("\nLogin unsuccessful");
        }
    }

    public void chooseMainMenuItem(User activeUser) {
        System.out.println("\nPlease make a menu selection.");
        System.out.println("\n1. List Books \n2. List Movies \n3. List User Account Details \n4. Quit");

        String input = readInput().toLowerCase();

        switch(input) {
            case "1":
                System.out.println("\nList Books selected");
                availableBooks.getAllAvailableBooks();
                bookNavigation(activeUser);
                break;
            case "2":
                System.out.println("\nList Movies selected");
                availableMovies.getAllAvailableMovies();
                movieNavigation(activeUser);
                break;
            case "3":
                activeUser.showContactInfo();
                chooseMainMenuItem(activeUser);
                break;
            case "4":
                System.out.println("\nExiting Program");
                break;
            default:
                System.out.println("\nSelect a valid option!");
                chooseMainMenuItem(activeUser);
        }
    }

    public void movieNavigation(User activeUser) {
        System.out.println("\nWhat would you like to do next?");
        System.out.println("\n- List Movies \n- Borrow Movie \n- Return Movie \n- Back \n- Quit");

        String input = readInput().toLowerCase();

        switch(input) {
            case "list movies":
                availableMovies.getAllAvailableMovies();
                movieNavigation(activeUser);
                break;
            case "borrow movie":
                System.out.println("To borrow, please input the movies title\n");
                String titleInputBorrow = readInput();
                availableMovies.checkMovieIsAvailableToBorrow(titleInputBorrow);
                movieNavigation(activeUser);
                break;
            case "return movie":
                System.out.println("To return, please input the movies title\n");
                String titleInputReturn = readInput();
                checkedOutMovies.checkMovieIsValidReturn(titleInputReturn);
                movieNavigation(activeUser);
                break;
            case "back":
                System.out.println("\nBack to Main Menu");
                chooseMainMenuItem(activeUser);
                break;
            case "quit":
                System.out.println("\nExiting Program");
                break;
            default:
                System.out.println("\nSelect a valid option!");
                movieNavigation(activeUser);
        }

    }

    public void bookNavigation(User activeUser) {
        System.out.println("\nWhat would you like to do next?");
        System.out.println("\n- List Books \n- Borrow Book \n- Return Book \n- Back \n- Quit");

        String input = readInput().toLowerCase();

        switch(input) {
            case "list books":
                availableBooks.getAllAvailableBooks();
                bookNavigation(activeUser);
                break;
            case "borrow book":
                System.out.println("To borrow, please input the books title\n");
                String titleInputBorrow = readInput();
                availableBooks.checkBookIsAvailableToBorrow(titleInputBorrow);
                bookNavigation(activeUser);
                break;
            case "return book":
                System.out.println("To return, please input the books title\n");
                String titleInputReturn = readInput();
                checkedOutBooks.checkBookIsValidReturn(titleInputReturn);
                bookNavigation(activeUser);
                break;
            case "back":
                System.out.println("\nBack to Main Menu");
                chooseMainMenuItem(activeUser);
                break;
            case "quit":
                System.out.println("\nExiting Program");
                break;
            default:
                System.out.println("\nSelect a valid option!");
                bookNavigation(activeUser);
        }

    }

}
