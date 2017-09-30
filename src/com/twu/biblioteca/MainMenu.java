package com.twu.biblioteca;

public class MainMenu {

    private static String[] menuItems = {"List Books", "List Movies"};

    public static String getMenuItem(int element){
        return menuItems[element];
    }

    public static void getAllItems(){
        System.out.println("Menu options:\n");
        for(String x: menuItems) {
            System.out.println(x);
        }
    }

    public static void chooseMenuItem() {
        System.out.println("Please make a menu selection.\n");
        getAllItems();
        String input = BibliotecaApp.readInput().toLowerCase();
        if (input.equals(getMenuItem(0).toLowerCase())) {
            System.out.println(getMenuItem(0) + " selected\n");
            AvailableBooks.getAllAvailableBooks();
            bookNavigation();
        }
        else if (input.equals(getMenuItem(1).toLowerCase())) {
            System.out.println(getMenuItem(1) + " selected\n");
            AvailableMovies.getAllAvailableMovies();
            movieNavigation();
        }
        else if (input.equals("quit")) {
            System.out.println("Exiting Program");
        }
        else {
            System.out.println("Select a valid option!\n");
            chooseMenuItem();
        }
    }

    public static void movieNavigation() {
        System.out.println("\nWhat would you like to do next?");
        System.out.println("\n- List Movies \n- Borrow Movie \n- Return Movie \n- Quit");

        String input = BibliotecaApp.readInput().toLowerCase();
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
            case "quit":
                System.out.println("Exiting Program");
                break;
            default:
                System.out.println("Select a valid option!");
                movieNavigation();
        }

    }

    public static void bookNavigation() {
        System.out.println("\nWhat would you like to do next?");
        System.out.println("\n- List Books \n- Borrow Book \n- Return Book \n- Quit");

        String input = BibliotecaApp.readInput().toLowerCase();
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
            case "quit":
                System.out.println("Exiting Program");
                break;
            default:
                System.out.println("Select a valid option!");
                bookNavigation();
        }

    }

}
