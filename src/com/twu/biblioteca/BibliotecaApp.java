package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Biblioteca");

        Book test = new Book("Game of Thrones", "Bob", 1900);
        Book test2 = new Book("Lord of the Rings", "John", 1950);

        for(Book x: ListBooks.bookList) {
            System.out.println(x);
            System.out.println(",");
        }

        System.out.println(ListBooks.bookList.size());
    }
}
