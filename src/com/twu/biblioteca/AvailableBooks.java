package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class AvailableBooks {

    private static List<Book> availableBooks = new ArrayList<Book>();

    public static Book getAvailableBook(int index){
        return availableBooks.get(index);
    }

    public static void addAvailableBook(Book book) {
        availableBooks.add(book);
    }

    public static void checkBookIsAvailableToBorrow(String title) {
        int index = getIndexByTitleInAvailable(title);
        if (index >= 0) {
            Book toBorrow = getAvailableBook(index);
            checkoutBook(toBorrow);
        } else {
            System.out.println("That book is not available.");
        }
    }

    public static void selectBookToBorrow() {
        System.out.println("To borrow, please input the books title\n");
        String titleInput = BibliotecaApp.readInput();
        checkBookIsAvailableToBorrow(titleInput);
    }


    public static int getIndexByTitleInAvailable(String title) {
        for(Book x: availableBooks) {
            if(x.getTitle().equals(title))   {
                return availableBooks.indexOf(x);
            }
        }
        return -1;
    }

    public static void deleteAllAvailableBooks() {
        availableBooks.clear();
    }


    public static void getAllAvailableBooks() {
        System.out.println("Available Books:\n");
        System.out.printf("%-30s%-30s%-20s%n", "Title", "Author", "Year");
        System.out.println("-----------------------------------------------------------------------");
        for (Book x : availableBooks) {
            System.out.println(x.showAll());
        }
        System.out.println("-----------------------------------------------------------------------");
    }


    public static void checkoutBook(Book book) {
        try {
            CheckedOutBooks.addCheckedOutBook(book);
            availableBooks.remove(book);
            System.out.println("Thank you! Enjoy the book.");
        } catch (Exception e) {
            System.out.println("That book is not available.");
        }
    }

    public static int availableBookListSize() {
        return availableBooks.size();
    }


}
