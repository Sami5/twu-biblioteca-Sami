package com.twu.biblioteca;

import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Biblioteca");

        Book book1 = new Book("Game of Thrones", "Bob", 1900);
        Book book2 = new Book("Lord of the Rings", "John", 1950);
        Book book3 = new Book("Harry Potter", "Victoria", 1857);
/*
        for(Book x: ListBooks.bookList) {
            System.out.println(x);
        }
*/

        ListBooks.getAllBooks();
        MainMenu.getAllItems();

    }
}
