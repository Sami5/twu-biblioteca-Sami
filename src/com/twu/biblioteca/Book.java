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

     public String showAll() {
         String title = this.getTitle();
         String author = this.getAuthor();
         String year = String.valueOf(this.getYear());

         String details = String.format("%-20s%-20s%-20s", title, author, year);
         return details;
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

}
