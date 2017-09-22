package com.twu.biblioteca;

public class Book {

     private String title;
     private String author;
     private int year;
     //private boolean isAvailable;

     public Book(String newTitle, String newAuthor, int newYear) {
         title = newTitle;
         author = newAuthor;
         year = newYear;
         //isAvailable = true;

         ListBooks.addAvailableBook(this);
     }

     public String getTitle() {
        return title;
     }

     public String getAuthor() {
         return author;
     }

     public int getYear() {
         return year;
     }

     //public boolean getIsAvailable() {return isAvailable;}

     public void setTitle(String newTitle) {
         title = newTitle;
     }

     public void setAuthor(String newAuthor) {
         author = newAuthor;
     }

     public void setYear(int newYear) {
         year = newYear;
     }

     //public void setIsAvailable(boolean newIsAvailable) { isAvailable = newIsAvailable;}


    @Override
    public String toString() {
       String title = this.getTitle();
       String author = this.getAuthor();
       String year = String.valueOf(this.getYear());

       String details = "Title: "+ title + ", " + "Author: " + author + ", " + "Year: " + year;
       return details;
    }
}
