package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Biblioteca");

        Book test = new Book("Game of Thrones", "Bob", 1900);
        System.out.println(test.getTitle());


    }
}
