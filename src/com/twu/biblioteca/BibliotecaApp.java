package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void existingBooks() {
        Book book1 = new Book("Game of Thrones", "Bob", 1900);
        Book book2 = new Book("Lord of the Rings", "John", 1950);
        Book book3 = new Book("Harry Potter", "Victoria", 1857);
        Book book4 = new Book("The Hobbit", "Boris", 1700);
    }

    public static void existingMovies() {
        Movie movie1 = new Movie("Titanic", 1997, "James Cameron", 10);
        Movie movie2 = new Movie("Alien", 1980, "John Smith", 8);
        Movie movie3 = new Movie("The Matrix", 1999, "Dracula", 9);
        Movie movie4 = new Movie("Pirates of the Caribbean", 1900, "Homer Simpson", 7);
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

        existingBooks();
        existingMovies();

        System.out.println("Welcome to Biblioteca\n");

        MainMenu.chooseMenuItem();

    }
}
