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

    public void checkoutItem(ItemType type, int itemId) throws ItemUnavailableException {
        if(type.equals(ItemType.BOOK))
            checkoutBook(itemId);
        else
            checkoutMovie(itemId);
    }

    public void returnItem(ItemType type, int itemId) throws NotValidItemToReturnException {
        if(type.equals(ItemType.BOOK))
            returnBook(itemId);
    }

    private List<Book> listAllBooks() {
        return mBooks;
    }

    private List<Book> listAllAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>(mBooks);
        availableBooks.removeIf(book -> !book.isAvailable());
        return availableBooks;
    }

    private void checkoutBook(int bookId) throws BookUnavailableException {
        try {
            Book choosedBook = findBookById(bookId);
            if(choosedBook.isAvailable())
                lockBook(bookId);
            else
                throw new BookUnavailableException();
        } catch (IllegalArgumentException e) {
            throw new BookUnavailableException();
        }
    }

    private void returnBook(int bookId) throws NotValidBookToReturnException {
        try {
            Book choosedBook = findBookById(bookId);
            if(!choosedBook.isAvailable())
                unlockBook(bookId);
            else
                throw new NotValidBookToReturnException();
        } catch (IllegalArgumentException e) {
            throw new NotValidBookToReturnException();
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

    private List<Movie> listAllMovies () {
        return mMovies;
    }

    private List<Movie> listAllAvailableMovies() {
        List<Movie> availableMovies = new ArrayList<>(mMovies);
        availableMovies.removeIf(movie -> !movie.isAvailable());
        return availableMovies;
    }

    private void checkoutMovie(int movieId) throws MovieUnavailableException {
        try {
            Movie choosedMovie = findMovieById(movieId);
            if(choosedMovie.isAvailable())
                lockMovie(movieId);
            else
                throw new MovieUnavailableException();
        } catch (IllegalArgumentException e) {
            throw new MovieUnavailableException();
        }
    }

    private Movie findMovieById(int movieId) {
        List<Movie> movies = new ArrayList<>(mMovies);

        for (Movie movie: movies) {
            if (movie.getMovieId().equals(movieId))
                return movie;
        }
        throw new IllegalArgumentException();
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
