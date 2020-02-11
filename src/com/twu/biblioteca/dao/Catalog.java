package com.twu.biblioteca.dao;

import com.twu.biblioteca.exceptions.*;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.model.ItemType;
import com.twu.biblioteca.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private List<Book> mBooks;
    private List<Movie> mMovies;

    public Catalog(List<Book> books, List<Movie> movies)  {
        mBooks = new ArrayList<>(books);
        mMovies = new ArrayList<>(movies);
    }

    public List<? extends Item> listAll(ItemType type) {
        if(type.equals(ItemType.BOOK))
            return listAllBooks();
        else
            return listAllMovies();
    }

    public List<? extends Item>  listAllAvailable(ItemType type) {
        if(type.equals(ItemType.BOOK))
            return listAllAvailableBooks();
        else
            return listAllAvailableMovies();
    }

    public boolean checkoutItem(ItemType type, int itemId) {
        boolean checkoutSuccessful = false;
        if(type.equals(ItemType.BOOK))
            checkoutSuccessful = checkoutBook(itemId);
        else
           checkoutSuccessful = checkoutMovie(itemId);

        return checkoutSuccessful;
    }

    public boolean returnItem(ItemType type, int itemId) throws NotValidItemToReturnException {
        boolean returnSuccessful = false;

        if(type.equals(ItemType.BOOK))
            returnSuccessful =  returnBook(itemId);

        return returnSuccessful;
    }

    private List<Book> listAllBooks() {
        return mBooks;
    }

    private List<Book> listAllAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>(mBooks);
        availableBooks.removeIf(book -> !book.isAvailable());
        return availableBooks;
    }

    private boolean checkoutBook(int bookId) {
        boolean checkoutSuceesful = false;
        Book choosedBook = findBookById(bookId);
        if(choosedBook.isAvailable()) {
            lockBook(bookId);
            checkoutSuceesful = true;
        }
        return checkoutSuceesful;
    }

    private boolean returnBook(int bookId) throws NotValidBookToReturnException {
        boolean returnSucessfull = false;
        Book choosedBook = findBookById(bookId);
        if(choosedBook != null) {
            if (!choosedBook.isAvailable()) {
                unlockBook(bookId);
                returnSucessfull = true;
            }
            return returnSucessfull;
        } else
            throw new NotValidBookToReturnException();
    }

    private Book findBookById(int bookId) {
        for (Book book: mBooks) {
            if (book.getBookId().equals(bookId))
                return book;
        }
        return null;
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

    private List<Movie> listAllMovies () {
        return mMovies;
    }

    private List<Movie> listAllAvailableMovies() {
        List<Movie> availableMovies = new ArrayList<>(mMovies);
        availableMovies.removeIf(movie -> !movie.isAvailable());
        return availableMovies;
    }

    private boolean checkoutMovie(int movieId) {
        boolean checkoutSuceesful = false;

        Movie choosedMovie = findMovieById(movieId);
        if(choosedMovie.isAvailable()) {
            lockMovie(movieId);
            checkoutSuceesful = true;
        }
        return checkoutSuceesful;
    }

    private Movie findMovieById(int movieId) {
        List<Movie> movies = new ArrayList<>(mMovies);

        for (Movie movie: movies) {
            if (movie.getMovieId().equals(movieId))
                return movie;
        }
        return null;
    }

    private void lockMovie(int movieId) {
        for (Movie movie: mMovies) {
            if (movie.getMovieId().equals(movieId)) {
                movie.setAvailable(false);
                return;
            }
        }
    }
}
