package com.twu.biblioteca.dao;

import com.twu.biblioteca.exceptions.InvalidLibraryNumberException;
import com.twu.biblioteca.model.Customer;
import com.twu.biblioteca.model.Librarian;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.util.Util;

import java.util.List;

public class RegisteredUsers {
    private List<User> mUsers;

    public RegisteredUsers(List<User> mUsers) {
        this.mUsers = mUsers;
    }

    public boolean correctPassword (String libraryNumber, String password1) {
        for (User user1: mUsers) {
            if(user1.sameLibraryNumber(libraryNumber))
                if (user1.samePassword(password1))
                    return true;
        }
        return false;
    }

    public User findUserById(String libraryNumber) throws InvalidLibraryNumberException {
        validLibraryNumberFormat(libraryNumber);
        for (User user1: mUsers) {
            if(user1.sameLibraryNumber(libraryNumber))
                return user1;
        }
        return null;
    }

    public static boolean validLibraryNumberFormat(String libraryNumber) throws InvalidLibraryNumberException {
        if(libraryNumber.length() == 8 && libraryNumber.charAt(3) == '-'
                && Util.isNumeric(libraryNumber.substring(0,3)) && Util.isNumeric(libraryNumber.substring(4,8)))
           return true;
        else
            throw new InvalidLibraryNumberException();
    }

    public static boolean isLibrarian(User user) {
        boolean librarian = false;

        if ((user instanceof Librarian))
            librarian = true;

        return librarian;
    }

    public static boolean isCustumer(User user) {
        boolean customer = false;

        if ((user instanceof Customer))
            customer = true;

        return customer;
    }

}
