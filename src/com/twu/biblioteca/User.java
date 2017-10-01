package com.twu.biblioteca;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private int phone;

    public User(String newLibraryNumber, String newPassword) {
        try {
            setLibraryNumber(newLibraryNumber);
            setPassword(newPassword);
        } catch (Exception e) {
            System.out.println("Invalid Library Number Format");
        }
    }

    public User(String newLibraryNumber, String newPassword, String newName, String newEmail, int newPhone) {
        try {
            setLibraryNumber(newLibraryNumber);
            setPassword(newPassword);
            setName(newName);
            setEmail(newEmail);
            setPhone(newPhone);
        } catch (Exception e) {
            System.out.println("Invalid Library Number Format");
        }
    }

    public String getLibraryNumber() {return libraryNumber;}

    public String getPassword() {return password;}

    public String getName() {return name;}

    public String getEmail() {return email;}

    public int getPhone() {return phone;}

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

    public void setPhone(int newPhone) {phone = newPhone;}

    public String showAll() {
        String libraryNumber = this.getLibraryNumber();
        String password = this.getPassword();
        String name = this.getName();
        String email = this.getEmail();
        int phone = this.getPhone();

        String details = String.format("%-30s%-30s%-30s%-30s%-20s", libraryNumber, password, name, email, phone);
        return details;

    }

}
