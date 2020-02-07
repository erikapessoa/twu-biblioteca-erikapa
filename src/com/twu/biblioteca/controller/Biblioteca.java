package com.twu.biblioteca.controller;

import com.twu.biblioteca.exceptions.BookUnavailableException;
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

    public String showAllBooksWithAuthorAndYear() {
        return Util.formatBookListWithAuthorAndYear(catalog.listAllBooks());
    }

    public static String showMainMenu() {
        return "(1) List of Books";
    }

    public String chooseMenuOption(String userChoice) {
        String optionResult;

        switch (userChoice) {
            case "1":
                optionResult = this.showAllBooks();
                break;
            case "q":
                optionResult = this.exit();
                break;
            default:
                optionResult = "Please select a valid option!";
        }

        return  optionResult;
    }

    public List<Book> chekoutABook(int bookId) {
        try {
            catalog.checkoutBook(bookId);

        } catch (BookUnavailableException e) {
            e.printStackTrace();
        }
        return catalog.listAllAvailableBooks();
    }
}
