package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class AvailableBooks {

    private List<Book> availableBooks = new ArrayList<Book>();
    private CheckedOutBooks checkedOutBooks;

    public void setCheckedOutBooks(CheckedOutBooks checkedOutBooks) {
        this.checkedOutBooks = checkedOutBooks;
    }

    public Book getAvailableBook(int index){
        return availableBooks.get(index);
    }

    public void addAvailableBook(Book book) {
        availableBooks.add(book);
    }

    public void checkBookIsAvailableToBorrow(String title, User activeUser) {
        int index = getIndexByTitleInAvailable(title);
        if (index >= 0) {
            Book toBorrow = getAvailableBook(index);
            checkoutBook(toBorrow, activeUser);
        } else {
            System.out.println("That book is not available.");
        }
    }

    public int getIndexByTitleInAvailable(String title) {
        for(Book x: availableBooks) {
            if(x.getTitle().equals(title)) {
                return availableBooks.indexOf(x);
            }
        }
        return -1;
    }

    public void deleteAllAvailableBooks() {
        availableBooks.clear();
    }


    public void getAllAvailableBooks() {
        System.out.println("Available Books:\n");
        System.out.printf("%-30s%-30s%-20s%n", "Title", "Author", "Year");
        System.out.println("-----------------------------------------------------------------------");
        for (Book x : availableBooks) {
            System.out.println(x.showAll());
        }
        System.out.println("-----------------------------------------------------------------------");
    }


    public void checkoutBook(Book book, User activeUser) {
        try {
            checkedOutBooks.addCheckedOutBook(book);
            availableBooks.remove(book);
            activeUser.addCheckedOutBook(book);
            System.out.println("Thank you! Enjoy the book.");
        } catch (Exception e) {
            System.out.println("That book is not available.");
        }
    }

    public int availableBookListSize() {
        return availableBooks.size();
    }


}
