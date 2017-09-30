package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class CheckedOutBooks {

    private static List<Book> checkedOutBooks = new ArrayList<Book>();

    public static Book getCheckedOutBook(int element) {
        return checkedOutBooks.get(element);
    }

    public static void addCheckedOutBook(Book book) {
        checkedOutBooks.add(book);
    }

    public static void checkBookIsValidReturn(String title) {
        int index = getIndexByTitleInCheckedOut(title);
        if (index >= 0) {
            Book toReturn = getCheckedOutBook(index);
            returnBook(toReturn);
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }

    public static void selectBookToReturn() {
        System.out.println("To return, please input the books title\n");
        String titleInput = BibliotecaApp.readInput();
        checkBookIsValidReturn(titleInput);
    }

    public static int getIndexByTitleInCheckedOut(String title) {
        for (Book x : checkedOutBooks) {
            if (x.getTitle().equals(title)) {
                return checkedOutBooks.indexOf(x);
            }
        }
        return -1;
    }

    public static void returnBook(Book book) {
        try {
            AvailableBooks.addAvailableBook(book);
            checkedOutBooks.remove(book);
            System.out.println("Thank you for returning the book.");
        } catch (Exception e) {
            System.out.println("That is not a valid book to return.");
        }
    }


    public static void getAllCheckedOutBooks() {
        System.out.println("Checked Out Books:\n");
        System.out.printf("%-30s%-30s%-20s%n", "Title", "Author", "Year");
        System.out.println("-----------------------------------------------------------------------");
        for (Book x : checkedOutBooks) {
            System.out.println(x.showAll());
        }
        System.out.println("-----------------------------------------------------------------------");
    }


    public static int checkedOutBookListSize() {
        return checkedOutBooks.size();
    }


    public static void deleteAllCheckedOutBooks() {
        checkedOutBooks.clear();
    }

}