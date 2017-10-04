package com.twu.biblioteca;

public class BibliotecaApp {

    public static AvailableBooks populateBooks() {
        AvailableBooks availableBooks = new AvailableBooks();

        availableBooks.addAvailableBook(new Book("Game of Thrones", "Bob", 1900));
        availableBooks.addAvailableBook(new Book("Game of Thrones", "Bob", 1900));
        availableBooks.addAvailableBook(new Book("Lord of the Rings", "John", 1950));
        availableBooks.addAvailableBook(new Book("Harry Potter", "Victoria", 1857));
        availableBooks.addAvailableBook(new Book("The Hobbit", "Boris", 1700));

        return availableBooks;
    }

    public static AvailableMovies populateMovies() {
        AvailableMovies availableMovies = new AvailableMovies();

        availableMovies.addAvailableMovie(new Movie("Titanic", 1997, "James Cameron", 10));
        availableMovies.addAvailableMovie(new Movie("Alien", 1980, "John Smith", 8));
        availableMovies.addAvailableMovie(new Movie("The Matrix", 1999, "Dracula", 9));
        availableMovies.addAvailableMovie(new Movie("Pirates of the Caribbean", 1900, "Homer Simpson", 7));

        return availableMovies;
    }

    public static UserList populateUsers() {
        UserList userList = new UserList();

        userList.addUser(new User("243-9405", "fsl5", "Nicole Jones", "nicole@hotmail.com", "0455555555"));
        userList.addUser(new User("247-9407", "sfn39s", "Amanda Carter", "amanda@hotmail.com", "0455555777"));
        userList.addUser(new User("253-9805", "vjld3", "James Anderson", "james@hotmail.com", "0454445555"));
        userList.addUser(new User("233-9995", "fls3", "Orlando Spencer", "orlando@hotmail.com", "0452225555"));

        return userList;
    }

    public static void main(String[] args) {

        AvailableBooks availableBooks = populateBooks();
        AvailableMovies availableMovies = populateMovies();
        UserList userList = populateUsers();

        CheckedOutBooks checkedOutBooks = new CheckedOutBooks();
        CheckedOutMovies checkedOutMovies = new CheckedOutMovies();

        MainMenu menu = new MainMenu(availableBooks, availableMovies, checkedOutBooks, checkedOutMovies, userList);

        availableBooks.setCheckedOutBooks(checkedOutBooks);
        checkedOutBooks.setAvailableBooks(availableBooks);
        availableMovies.setCheckedOutMovies(checkedOutMovies);
        checkedOutMovies.setAvailableMovies(availableMovies);

        System.out.println("Welcome to Biblioteca");

        //menu.chooseMainMenuItem();



    }
}
