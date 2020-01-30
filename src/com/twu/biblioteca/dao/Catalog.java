package com.twu.biblioteca.dao;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private List<Book> mBooks;

    public Catalog(List<Book> books)  {

        mBooks = new ArrayList<>(books);
    }

    public List<Book> listAllBooks() {
        return mBooks;
    }

    /*
    public List<Book> listAllAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>(mBooks);

        availableBooks.removeIf(book -> !book.isAvailable());

        return availableBooks;
    }

    public String checkoutABook(int bookId) {
        String checkoutSuccessful = "Thank you! Enjoy the book.";
        String checkoutUnsuccessful = "Sorry, that book is not available.";
        Book choosedBook = findBookWithId(bookId);

        if(choosedBook.isAvailable()) {
            choosedBook.setAvailable(false);
            return checkoutSuccessful;
        } else
            return checkoutUnsuccessful;
    }

    public String returnABook(int bookId) {

        String returnSuccessful = "Thank you for returning the book.";
        String returnUnsuccessful =  "That is not a valid book to return.";

        try {
            Book returnedBook = findBookWithId(bookId);

            if(!returnedBook.isAvailable()) {
                returnedBook.setAvailable(true);
                return returnSuccessful;
            } else
                return returnUnsuccessful;
        } catch (IllegalArgumentException e) {
            return returnUnsuccessful;
        }
    }

    private Book findBookWithId(int bookId) {
        for (Book book:
                mBooks) {
            if (book.getBookId().equals(bookId))
                return book;
        }
        throw new IllegalArgumentException();
    }


     */
}
