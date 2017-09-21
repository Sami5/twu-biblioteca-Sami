package com.twu.biblioteca;

public class MainMenu {

    private static String[] menuItems = {"List Books"};

    public static String getMenuItem(int element){
        return menuItems[element];
    }

    public static void getAllItems(){
        for(String x: MainMenu.menuItems) {
            System.out.println(x);
        }
    }

}
