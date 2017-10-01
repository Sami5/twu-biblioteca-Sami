package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void populateBooks() {
        Book book1 = new Book("Game of Thrones", "Bob", 1900);
        Book book2 = new Book("Lord of the Rings", "John", 1950);
        Book book3 = new Book("Harry Potter", "Victoria", 1857);
        Book book4 = new Book("The Hobbit", "Boris", 1700);
    }

    public static void populateMovies() {
        Movie movie1 = new Movie("Titanic", 1997, "James Cameron", 10);
        Movie movie2 = new Movie("Alien", 1980, "John Smith", 8);
        Movie movie3 = new Movie("The Matrix", 1999, "Dracula", 9);
        Movie movie4 = new Movie("Pirates of the Caribbean", 1900, "Homer Simpson", 7);
    }

    public static void populateUsers() {
        User user1 = new User("243-9405", "fsl5", "Nicole Jones", "nicole@hotmail.com", "0455555555");
        User user2 = new User("247-9407", "sfn39s", "Amanda Carter", "amanda@hotmail.com", "0455555777");
        User user3 = new User("253-9805", "vjld3", "James Anderson", "james@hotmail.com", "0454445555");
        User user4 = new User("233-9995", "fls3", "Orlando Spencer", "orlando@hotmail.com", "0452225555");
    }

    public static String readInput() {
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        System.out.print("\nPlease enter input: \n");
        String input = scan.next();
        //scan.close();
        System.out.println("");
        return input;
    }

    public static void main(String[] args) {

        populateBooks();
        populateMovies();
        populateUsers();

        System.out.println("Welcome to Biblioteca");

        MainMenu.chooseMainMenuItem();

        //User user1 = new User("243-9405", "fsl5", "Nicole Jones", "nicole@hotmail.com", 0455555555);
        //user1.getAllCheckedOutMovies();

    }
}
