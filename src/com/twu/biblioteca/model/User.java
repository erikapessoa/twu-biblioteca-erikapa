package com.twu.biblioteca.model;

import sun.security.util.Password;

import java.util.Objects;

public class User {
    private String libraryNumber;
    private String password; //needs refactoring to consider security and encryption

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    protected void setLibraryNumber(String libraryNumber) {
        this.libraryNumber = libraryNumber;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public boolean samePassword (String password1) {
        return this.getPassword().equals(password1);
    }

    public boolean sameLibraryNumber (String libraryNumber1) {
        return this.getLibraryNumber().equals(libraryNumber1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return libraryNumber.equals(user.libraryNumber) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryNumber, password);
    }
}
