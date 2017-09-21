package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class ListBooks {

    private static List<Book> bookList = new ArrayList<Book>();

    public static Book getBook(int element){
        return bookList.get(element);
    }

    public static void getAllBooks() {
        for (Book x : bookList) {
            System.out.println(x);
        }
    }

    public static void addBook(Book book) {
        bookList.add(book);
    }

    public static int bookListSize() {
        return bookList.size();
    }

}
