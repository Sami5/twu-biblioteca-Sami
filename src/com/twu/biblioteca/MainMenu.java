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
        String input = BibliotecaApp.readInput();
        if (input.equals(getMenuItem(0))){
            System.out.println(getMenuItem(0) + " selected");
        } else {
            System.out.println("Select a valid option!");
            chooseMenuItem();
        }
    }

}
