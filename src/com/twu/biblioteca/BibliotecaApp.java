package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static void existingBooks() {
        Book book1 = new Book("Game of Thrones", "Bob", 1900);
        Book book2 = new Book("Lord of the Rings", "John", 1950);
        Book book3 = new Book("Harry Potter", "Victoria", 1857);
    }

    public static String readInput() {
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Please enter input: ");
        String input = scan.next();
        scan.close();
        System.out.println("");
        return input;
    }

    public static void main(String[] args) {
        Book book4 = new Book("Harry Potter", "Victoria", 1857);

        existingBooks();

        System.out.println("Welcome to Biblioteca\n");

        //MainMenu.chooseMenuItem();

        //ListBooks.selectBookToBorrow();

        //System.out.println(book4.showAll());

        ListBooks.getAllAvailableBooks();

        //Book book4 = new Book("Harry Potter", "Victoria", 1857);

        //System.out.println("show all :");
        //System.out.println(book4.showAll());

        //System.out.println(readInput());

    }
}
