package com.twu.biblioteca.model;

public class Customer extends User {

    private String name;
    private String email;
    private String phoneNumber;

    public Customer(String libraryNumber, String password, String name, String email, String phoneNumber) {
        super(libraryNumber, password);
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
