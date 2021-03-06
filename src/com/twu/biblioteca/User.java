package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class User {

    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private String phone;
    private  List<Book> checkedOutBooks = new ArrayList<Book>();
    private  List<Movie> checkedOutMovies = new ArrayList<Movie>();

    public User(String newLibraryNumber, String newPassword) {
        try {
            setLibraryNumber(newLibraryNumber);
            setPassword(newPassword);

            //UserList.addUser(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public User(String newLibraryNumber, String newPassword, String newName, String newEmail, String newPhone) {
        try {
            setLibraryNumber(newLibraryNumber);
            setPassword(newPassword);
            setName(newName);
            setEmail(newEmail);
            setPhone(newPhone);

            //UserList.addUser(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getLibraryNumber() {return libraryNumber;}

    public String getPassword() {return password;}

    public String getName() {return name;}

    public String getEmail() {return email;}

    public String getPhone() {return phone;}

    public void setLibraryNumber(String newLibraryNumber) {
        // Format must equal xxx-xxxx

        String numberPattern = "\\b\\d{3,3}\\-\\d{4,4}$";

        if (Pattern.matches(numberPattern, newLibraryNumber)) {
            libraryNumber = newLibraryNumber;
        } else {
            throw new IllegalArgumentException("Invalid Library Number Format");
        }
    }

    public void setPassword(String newPassword) {password = newPassword;}

    public void setName(String newName) {name = newName;}

    public void setEmail(String newEmail) {email = newEmail;}

    public void setPhone(String newPhone) {phone = newPhone;}

    public void addCheckedOutBook(Book book) {checkedOutBooks.add(book); }

    public void removeCheckedOutBook(Book book) {checkedOutBooks.remove(book);}

    public void addCheckedOutMovie(Movie movie) {checkedOutMovies.add(movie);}

    public void removeCheckedOutMovie(Movie movie) {checkedOutMovies.remove(movie);}

    public String showAll() {
        String libraryNumber = this.getLibraryNumber();
        String password = this.getPassword();
        String name = this.getName();
        String email = this.getEmail();
        String phone = this.getPhone();

        String details = String.format("%-30s%-30s%-30s%-30s%-20s", libraryNumber, password, name, email, phone);
        return details;
    }

    public void showContactInfo() {
        String name = this.getName();
        String email = this.getEmail();
        String phone = this.getPhone();

        System.out.println(getName() + " - User Account Details:\n");
        System.out.printf("%-30s%-30s%-20s%n", "Name", "Email", "Phone");
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-30s%-30s%-20s", name, email, phone);
        System.out.println("\n-----------------------------------------------------------------------");
    }

    public void getAllCheckedOutBooks() {
        System.out.println(getName() + " - Checked Out Books:\n");
        System.out.printf("%-30s%-30s%-20s%n", "Title", "Author", "Year");
        System.out.println("-----------------------------------------------------------------------");
        for (Book x : checkedOutBooks) {
            System.out.println(x.showAll());
        }
        System.out.println("-----------------------------------------------------------------------");
    }

    public void getAllCheckedOutMovies() {
        System.out.println(getName() + " - Checked Out Movies:\n");
        System.out.printf("%-30s%-20s%-30s%-20s", "Name", "Year", "Director", "Movie Rating");
        System.out.println("\n--------------------------------------------------------------------------------------------------");
        for (Movie x : checkedOutMovies) {
            System.out.println(x.showAll());
        }
        System.out.println("--------------------------------------------------------------------------------------------------");
    }

    public int checkedOutBooksListSize() {
        return checkedOutBooks.size();
    }

    public int checkedOutMoviesListSize() {
        return checkedOutMovies.size();
    }

}
