package com.twu.biblioteca.controller;

import com.twu.biblioteca.exceptions.BookUnavailableException;
import com.twu.biblioteca.exceptions.MovieUnavailableException;
import com.twu.biblioteca.exceptions.NotValidBookToReturnException;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.util.Util;
import com.twu.biblioteca.dao.Catalog;

import java.util.List;

public class Biblioteca {
    private Catalog catalog;

    public Biblioteca(Catalog catalog) {
        this.catalog = catalog;
    }

    public static String welcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangalore!";
    }

    public String exit() {
         return "Bye";
    }

    public String showAllBooks() {
        return Util.formatBookListTitles(catalog.listAllBooks());
    }

    public String showAvailableBooksWithId() {
        return Util.formatBookListWithTitleAndId(catalog.listAllAvailableBooks());
    }

    public String showAllBooksWithAuthorAndYear() {
        return Util.formatBookListWithAuthorAndYear(catalog.listAllBooks());
    }

    public static String showMainMenu() {
        return "(1) List of Books\n(2) Checkout a book\n(3) Return a book\n(q) Exit";
    }

    public String chooseMenuOption(String userChoice) {
        String optionResult;

        switch (userChoice) {
            case "1":
                optionResult = this.showAvailableBooksWithId();
                break;
            case "q":
                optionResult = this.exit();
                break;
            case "2":
                optionResult = "Write the id from the book you like to checkout: ";
                break;
            case "3":
                optionResult = "Write the id from the book you like to return: ";
                break;
            default:
                optionResult = "Please select a valid option!";
        }

        return  optionResult;
    }

    public String chekoutABook(int bookId) {
        String msg = "Thank you! Enjoy the book.";
        try {
            catalog.checkoutBook(bookId);
            return msg;
        } catch (BookUnavailableException e) {
            msg = e.getMessage();
            return msg;
        }
    }

    public String returnABook(int bookId) {
        String msg = "Thank you for returning the book.";
        try {
            catalog.returnBook(bookId);
            return msg;
        } catch (NotValidBookToReturnException e) {
            msg = e.getMessage();
            return msg;
        }
    }

    public String showAvailableMoviesWithId() {
        return Util.formatMovieListWithTitleAndId(catalog.listAllAvailableMovies());
    }

    public String chekoutAMovie(int movieId) {
        String msg = "Thank you! Enjoy the movie.";
        try {
            catalog.checkoutMovie(movieId);
            return msg;
        } catch (MovieUnavailableException e) {
            msg = e.getMessage();
            return msg;
        }
    }
}
