package com.twu.biblioteca.controller;

import com.twu.biblioteca.dao.RegisteredUsers;
import com.twu.biblioteca.exceptions.*;
import com.twu.biblioteca.model.ItemType;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.util.Util;
import com.twu.biblioteca.dao.Catalog;

public class Biblioteca {
    private Catalog mCatalog;
    private RegisteredUsers mLibraryUsers;
    private User mUserLoggedIn;

    public Biblioteca(Catalog catalog, RegisteredUsers libraryUsers) {
        this.mCatalog = catalog;
        this.mLibraryUsers = libraryUsers;
    }

    public static String welcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangalore!";
    }

    public String exit() {
         return "Bye";
    }

    public String showAllBooks() {
        return Util.formatBookListTitles(mCatalog.listAll(ItemType.BOOK));
    }

    public String showAvailableBooksWithId() {
        return Util.formatBookListWithTitleAndId(mCatalog.listAllAvailable(ItemType.BOOK));
    }

    public String showAllBooksWithAuthorAndYear() {
        return Util.formatBookListWithAuthorAndYear(mCatalog.listAll(ItemType.BOOK));
    }

    public String showMainMenu() {
        if (returnUserLoggedIn() != null) {
            if (RegisteredUsers.isLibrarian(returnUserLoggedIn()))
                return "(1) List of Books\n(2) Checkout a book\n(3) Return a book\n(4) List of Movies\n(5) Checkout a movie\n(q) Exit";
        }

        return "(1) List of Books\n(4) List of Movies\n(q) Exit";
    }

    public String chooseMenuOption(String userChoice) {
        String optionResult = "Please select a valid option!";

        if (returnUserLoggedIn() != null) {
            if (RegisteredUsers.isLibrarian(returnUserLoggedIn())) {
                switch (userChoice) {
                    case "1":
                        optionResult = this.showAvailableBooksWithId();
                        break;
                    case "2":
                        optionResult = "Write the id from the book you like to checkout: ";
                        break;
                    case "3":
                        optionResult = "Write the id from the book you like to return: ";
                        break;
                    case "4":
                        optionResult = this.showAvailableMoviesWithId();
                        break;
                    case "5":
                        optionResult = "Write the id from the movie you like to checkout: ";
                        break;
                    case "q":
                        optionResult = this.exit();
                        break;
                    default:
                        optionResult = "Please select a valid option!";
                }
            }
        } else {
            switch (userChoice) {
                case "1":
                    optionResult = this.showAvailableBooksWithId();
                    break;
                case "4":
                    optionResult = this.showAvailableMoviesWithId();
                    break;
                case "q":
                    optionResult = this.exit();
                    break;
                default:
                    optionResult = "Please select a valid option!";
            }
        }

        return  optionResult;
    }

    public String chekoutABook(int bookId) {
        String msg = "Sorry, that book is not available.";
        if (mCatalog.checkoutItem(ItemType.BOOK, bookId))
            msg = "Thank you! Enjoy the book.";
        return msg;
    }

    public String returnABook(int bookId) {
        String msg = "Thank you for returning the book.";
        try {
            mCatalog.returnItem(ItemType.BOOK, bookId);
            return msg;
        } catch (NotValidItemToReturnException e) {
            msg = e.getMessage();
            return msg;
        }
    }

    public String showAvailableMoviesWithId() {
        return Util.formatMovieListWithTitleAndId(mCatalog.listAllAvailable(ItemType.MOVIE));
    }

    public String chekoutAMovie(int movieId) {
        String msg = "Sorry, that movie is not available.";
        if (mCatalog.checkoutItem(ItemType.MOVIE, movieId))
            msg = "Thank you! Enjoy the movie.";
        return msg;
    }

    public boolean userLogin(String libraryNumber, String password) throws InvalidLibraryNumberException {
        boolean successfulLogin = false;

        User user = mLibraryUsers.findUserById(libraryNumber);
        if(user != null) {
            if (mLibraryUsers.correctPassword(libraryNumber, password)) {
                mUserLoggedIn = user;
                successfulLogin = true;
            }
        }
        return successfulLogin;
    }

    public User returnUserLoggedIn() {
        return this.mUserLoggedIn;
    }

    public static boolean validLibraryNumberFormat(String libraryNumber) {
        try {
            RegisteredUsers.validLibraryNumberFormat(libraryNumber);
            return true;
        } catch (InvalidLibraryNumberException e) {
            return false;
        }
    }

    public boolean userIsLibrarian() {
        boolean librarian = false;

        if(returnUserLoggedIn() != null && RegisteredUsers.isLibrarian(returnUserLoggedIn()))
            librarian = true;

        return librarian;
    }
}
