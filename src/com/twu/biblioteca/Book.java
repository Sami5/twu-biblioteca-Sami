package com.twu.biblioteca;

public class Book {

     private String title;
     private String author;
     private int year;

     public Book(String newTitle, String newAuthor, int newYear) {
         setTitle(newTitle);
         setAuthor(newAuthor);
         setYear(newYear);

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

     public void setTitle(String newTitle) {
         title = newTitle;
     }

     public void setAuthor(String newAuthor) {
         author = newAuthor;
     }

     public void setYear(int newYear) {
         year = newYear;
     }

    public String showAll() {
        String title = this.getTitle();
        String author = this.getAuthor();
        int year = this.getYear();

        String details = String.format("%-20s%-20s%-20s", title, author, year);
        return details;
    }

}
