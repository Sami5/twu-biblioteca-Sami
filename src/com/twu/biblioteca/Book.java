package com.twu.biblioteca;

public class Book {

     private String title;
     private String author;
     private int yearPublished;

     public Book(String newTitle, String newAuthor, int newYearPublished) {
         title = newTitle;
         author = newAuthor;
         yearPublished = newYearPublished;

         ListBooks.bookList.add(this);
     }

     public String getTitle() {
        return title;
     }

     public String getAuthor() {
         return author;
     }

     public int getYearPublished() {
         return yearPublished;
     }

     public void setTitle(String newTitle) {
         title = newTitle;
     }

     public void setAuthor(String newAuthor) {
         author = newAuthor;
     }

     public void setYearPublished(int newYearPublished) {
         yearPublished = newYearPublished;
     }

     @Override
     public String toString() {
         return this.getTitle();
     }


}
