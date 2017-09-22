package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class ListBooks {

    private static List<Book> availableBooks = new ArrayList<Book>();

    private static List<Book> checkedOutBooks = new ArrayList<Book>();

    public static int getIndexByTitle(String title) {
        for(Book x: availableBooks) {
            if(x.getTitle() == title)   {
                return availableBooks.indexOf(x);
            }
        }
        return -1;
    }

    public static Book findAvailableBookByTitle(int index){
        return getAvailableBook(index);
    }

    public static void deleteAllAvailableBooks() {
        availableBooks.clear();
    }

    public static Book getAvailableBook(int element){
        return availableBooks.get(element);
    }

    public static void getAllAvailableBooks() {
        for (Book x : availableBooks) {
            System.out.println(x);
        }
    }

    public static void addAvailableBook(Book book) {
        availableBooks.add(book);
    }


    public static void checkoutBook(Book book) {
        try {
            checkedOutBooks.add(book);
            availableBooks.remove(book);
            System.out.println("Thank you! Enjoy the book.");
        } catch (Exception e) {
            System.out.println("That book is not available.");
        }
    }

    public static void returnBook(Book book) {
        try {
            availableBooks.add(book);
            checkedOutBooks.remove(book);
            System.out.println("Thank you for returning the book.");
        } catch (Exception e) {
            System.out.println("That is not a valid book to return.");
        }
    }

    public static int availableBookListSize() {
        return availableBooks.size();
    }


    public static Book getCheckedOutBook(int element){
        return checkedOutBooks.get(element);
    }

    public static void getAllCheckedOutBooks() {
        for (Book x : checkedOutBooks) {
            System.out.println(x);
        }
    }

    public static void addCheckedOutBook(Book book) {
        checkedOutBooks.add(book);
    }

    public static int checkedOutBookListSize() {
        return checkedOutBooks.size();
    }

}
