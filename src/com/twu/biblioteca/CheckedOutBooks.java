package com.twu.biblioteca;

import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;

public class CheckedOutBooks {

    private List<Book> checkedOutBooks = new ArrayList<Book>();
    private AvailableBooks availableBooks;

    public void setAvailableBooks(AvailableBooks availableBooks){
        this.availableBooks = availableBooks;
    }

    public Book getCheckedOutBook(int element) {
        return checkedOutBooks.get(element);
    }

    public void addCheckedOutBook(Book book) {
        checkedOutBooks.add(book);
    }

    public void checkBookIsValidReturn(String title) {
        int index = getIndexByTitleInCheckedOut(title);
        if (index >= 0) {
            Book toReturn = getCheckedOutBook(index);
            returnBook(toReturn);
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }

    public int getIndexByTitleInCheckedOut(String title) {
        for (Book x : checkedOutBooks) {
            if (x.getTitle().equals(title)) {
                return checkedOutBooks.indexOf(x);
            }
        }
        return -1;
    }

    public void returnBook(Book book) {
        try {
            availableBooks.addAvailableBook(book);
            checkedOutBooks.remove(book);
            System.out.println("Thank you for returning the book.");
        } catch (Exception e) {
            System.out.println("That is not a valid book to return.");
        }
    }


    public void getAllCheckedOutBooks() {
        System.out.println("Checked Out Books:\n");
        System.out.printf("%-30s%-30s%-20s%n", "Title", "Author", "Year");
        System.out.println("-----------------------------------------------------------------------");
        for (Book x : checkedOutBooks) {
            System.out.println(x.showAll());
        }
        System.out.println("-----------------------------------------------------------------------");
    }


    public int checkedOutBookListSize() {
        return checkedOutBooks.size();
    }


    public void deleteAllCheckedOutBooks() {
        checkedOutBooks.clear();
    }

}