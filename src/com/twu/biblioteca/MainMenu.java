package com.twu.biblioteca;

public class MainMenu {

    private static String[] menuItems = {"List Books"};

    public static String getMenuItem(int element){
        return menuItems[element];
    }

    public static void getAllItems(){
        System.out.println("Menu selections:");
        for(String x: menuItems) {
            System.out.println(x);
        }
        System.out.println("");
    }

    public static void chooseMenuItem() {
        getAllItems();
        System.out.println("Please make menu selection\n");
        String input = BibliotecaApp.readInput().toLowerCase();
        if (input.equals(getMenuItem(0).toLowerCase())) {
            System.out.println(getMenuItem(0) + " selected\n");
            ListBooks.getAllAvailableBooks();
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
                ListBooks.getAllAvailableBooks();
                navigation();
                break;
            case "borrow book":
                ListBooks.selectBookToBorrow();
                navigation();
                break;
            case "return book":
                ListBooks.selectBookToReturn();
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
