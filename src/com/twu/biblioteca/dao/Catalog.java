package com.twu.biblioteca.dao;

import com.twu.biblioteca.exceptions.BookUnavailableException;
import com.twu.biblioteca.model.Book;

import java.time.Year;
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

    public List<Book> listAllAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>(mBooks);
        availableBooks.removeIf(book -> !book.isAvailable());
        return availableBooks;
    }

    public void checkoutBook(int bookId) throws BookUnavailableException {
        Book choosedBook = findBookById(bookId);
        try {
            if(choosedBook.isAvailable())
                lockBook(bookId);
            else
                throw new BookUnavailableException();
        } catch (IllegalArgumentException e) {
            throw new BookUnavailableException();
        }
    }

    private Book findBookById(int bookId) {
        for (Book book: mBooks) {
            if (book.getBookId().equals(bookId))
                return book;
        }
        throw new IllegalArgumentException();
    }

    private void lockBook(int bookId) {
        for (Book book: mBooks) {
            if (book.getBookId().equals(bookId)) {
                book.setAvailable(false);
                return;
            }
        }
    }

    private void unlockBook(int bookId) {
        for (Book book: mBooks) {
            if (book.getBookId().equals(bookId)) {
                book.setAvailable(true);
                return;
            }
        }
    }
}
