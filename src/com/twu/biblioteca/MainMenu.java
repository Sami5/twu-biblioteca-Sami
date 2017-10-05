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
        System.out.println("\nPlease make a menu selection by entering the relevant number.");
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
        System.out.println("\n1. List Movies \n2. Borrow Movie \n3. Return Movie \n4. Back \n5. Quit");

        String input = readInput().toLowerCase();

        switch(input) {
            case "1":
                availableMovies.getAllAvailableMovies();
                movieNavigation(activeUser);
                break;
            case "2":
                System.out.println("To borrow, please input the movies title\n");
                String titleInputBorrow = readInput();
                availableMovies.checkMovieIsAvailableToBorrow(titleInputBorrow, activeUser);
                activeUser.getAllCheckedOutMovies(); // delete line once test complete
                movieNavigation(activeUser);
                break;
            case "3":
                System.out.println("To return, please input the movies title\n");
                String titleInputReturn = readInput();
                checkedOutMovies.checkMovieIsValidReturn(titleInputReturn, activeUser);
                activeUser.getAllCheckedOutMovies(); // delete line once test complete
                movieNavigation(activeUser);
                break;
            case "4":
                System.out.println("\nBack to Main Menu");
                chooseMainMenuItem(activeUser);
                break;
            case "5":
                System.out.println("\nExiting Program");
                break;
            default:
                System.out.println("\nSelect a valid option!");
                movieNavigation(activeUser);
        }

    }

    public void bookNavigation(User activeUser) {
        System.out.println("\nWhat would you like to do next?");
        System.out.println("\n1. List Books \n2. Borrow Book \n3. Return Book \n4. Back \n5. Quit");

        String input = readInput().toLowerCase();

        switch(input) {
            case "1":
                availableBooks.getAllAvailableBooks();
                bookNavigation(activeUser);
                break;
            case "2":
                System.out.println("To borrow, please input the books title\n");
                String titleInputBorrow = readInput();
                availableBooks.checkBookIsAvailableToBorrow(titleInputBorrow, activeUser);
                activeUser.getAllCheckedOutBooks(); // delete line once test complete
                bookNavigation(activeUser);
                break;
            case "3":
                System.out.println("To return, please input the books title\n");
                String titleInputReturn = readInput();
                checkedOutBooks.checkBookIsValidReturn(titleInputReturn, activeUser);
                activeUser.getAllCheckedOutBooks(); // delete line once test complete
                bookNavigation(activeUser);
                break;
            case "4":
                System.out.println("\nBack to Main Menu");
                chooseMainMenuItem(activeUser);
                break;
            case "5":
                System.out.println("\nExiting Program");
                break;
            default:
                System.out.println("\nSelect a valid option!");
                bookNavigation(activeUser);
        }

    }

}
