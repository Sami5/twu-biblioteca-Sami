package com.twu.biblioteca;

public class MainMenu {

    private static String[] menuItems = {"List Books"};

    public static String getMenuItem(int element){
        return menuItems[element];
    }

    public static void getAllItems(){
        System.out.println("Menu options:");
        for(String x: menuItems) {
            System.out.println(x);
        }
    }

    public static void chooseMenuItem() {
        System.out.println("Please make menu selection.\n");
        getAllItems();
        String input = BibliotecaApp.readInput().toLowerCase();
        if (input.equals(getMenuItem(0).toLowerCase())) {
            System.out.println(getMenuItem(0) + " selected\n");
            AvailableBooks.getAllAvailableBooks();
            navigation();
        } else if (input.equals("quit")) {
            System.out.println("Exiting Program");
        } else {
            System.out.println("Select a valid option!");
            chooseMenuItem();
        }
    }

    public static void navigation() {
        System.out.println("\nWhat would you like to do next?");
        System.out.println("\n- List Books \n- Borrow Book \n- Return Book \n- Quit");

        String input = BibliotecaApp.readInput().toLowerCase();
        switch(input) {
            case "list books":
                AvailableBooks.getAllAvailableBooks();
                navigation();
                break;
            case "borrow book":
                AvailableBooks.selectBookToBorrow();
                navigation();
                break;
            case "return book":
                CheckedOutBooks.selectBookToReturn();
                navigation();
                break;
            case "quit":
                System.out.println("Exiting Program");
                break;
            default:
                System.out.println("Select a valid option!");
                navigation();
        }

    }

}
