package com.twu.biblioteca;

import com.twu.biblioteca.controller.Biblioteca;
import com.twu.biblioteca.dao.Catalog;
import com.twu.biblioteca.exceptions.BookUnavailableException;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import org.junit.Test;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BibliotecaTest {

    @Test
    public void welcomeMessage() {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangalore!";

        assertEquals(welcomeMessage, Biblioteca.welcomeMessage());
    }

    @Test
    public void showListOfBooks() {
        //Given
        String expectedBooks = "Book 1\n";
        Catalog catalogMock = mock(Catalog.class);
        Biblioteca bib = new Biblioteca(catalogMock);
        Book book1 = mock(Book.class);
        List<Book> books = new ArrayList<>();
        books.add(book1);

        //when
        when(book1.getTitle()).thenReturn("Book 1");
        when(catalogMock.listAllBooks()).thenReturn(books);

        //then
        assertEquals(expectedBooks, bib.showAllBooks());
    }

    @Test
    public void showListOfBooksWithAuthorAndYear() {
        //Given
        String expectedBooks = "Book 1 | Author 1 | 2015\n";
        Catalog catalogMock = mock(Catalog.class);
        Biblioteca bib = new Biblioteca(catalogMock);
        Book book1 = mock(Book.class);
        List<Book> books = new ArrayList<>();
        books.add(book1);

        //when
        when(book1.getTitle()).thenReturn("Book 1");
        when(book1.getAuthor()).thenReturn("Author 1");
        when(book1.publicationYear()).thenReturn("2015");
        when(catalogMock.listAllBooks()).thenReturn(books);

        //then
        assertEquals(expectedBooks, bib.showAllBooksWithAuthorAndYear());
    }

    @Test
    public void showAvailableBooksWithId() {
        //Given
        String expectedBooks = "(1) Book 1\n";
        Catalog catalogMock = mock(Catalog.class);
        Biblioteca bib = new Biblioteca(catalogMock);
        Book book1 = mock(Book.class);
        List<Book> books = new ArrayList<>();
        books.add(book1);

        //when
        when(book1.getBookId()).thenReturn(1);
        when(book1.getTitle()).thenReturn("Book 1");
        when(book1.isAvailable()).thenReturn(true);
        when(catalogMock.listAllAvailableBooks()).thenReturn(books);

        //then
        assertEquals(expectedBooks, bib.showAvailableBooksWithId());
    }

    @Test
    public void showMainMenu() {
        //Given
        String expected = "(1) List of Books\n(2) Checkout a book\n(3) Return a book\n(q) Exit";
        //when
        String actual = Biblioteca.showMainMenu();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void chooseInvalidMenuOption() {
        //Given
        String expected = "Please select a valid option!";
        Catalog catalog = mock(Catalog.class);
        Biblioteca bib = new Biblioteca(catalog);
        //when
        String actual = bib.chooseMenuOption("-1000");
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void chooseCloseApplication() {
        //Given
        String expected = "Bye";
        Catalog catalog = mock(Catalog.class);
        Biblioteca bib = new Biblioteca(catalog);
        //when
        String actual = bib.chooseMenuOption("q");
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void checkoutABook() {
        //Given
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"Book1", "Author 1", Year.now()));
        books.add(new Book(2,"Book2", "Author 2", Year.now()));
        Catalog catalog = new Catalog(books, new ArrayList<>());
        Biblioteca bib = new Biblioteca(catalog);
        String msgSucessfulCheckout = "Thank you! Enjoy the book.";

        //when
        String actual = bib.chekoutABook(2);

        //then
        assertEquals(msgSucessfulCheckout, actual);
    }

    @Test
    public void checkoutABookUnsuccessful() {
        //Given
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"Book1", "Author 1", Year.now()));
        books.add(new Book(2,"Book2", "Author 2", Year.now()));
        books.get(1).setAvailable(false);
        Catalog catalog = new Catalog(books, new ArrayList<>());
        Biblioteca bib = new Biblioteca(catalog);
        String msgUnsucessfullChekout = "Sorry, that book is not available";

        //when
        String actual = bib.chekoutABook(2);

        //then
        assertEquals(msgUnsucessfullChekout, actual);
    }

    @Test
    public void returnABook() {
        //Given
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"Book1", "Author 1", Year.now()));
        books.add(new Book(2,"Book2", "Author 2", Year.now()));
        books.get(1).setAvailable(false);
        Catalog catalog = new Catalog(books, new ArrayList<>());
        Biblioteca bib = new Biblioteca(catalog);
        String msgSucessfulReturn = "Thank you for returning the book.";

        //when
        String actual = bib.returnABook(2);

        //then
        assertEquals(msgSucessfulReturn, actual);
    }

    @Test
    public void returnABookUnsuccessful() {
        //Given
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"Book1", "Author 1", Year.now()));
        books.add(new Book(2,"Book2", "Author 2", Year.now()));
        Catalog catalog = new Catalog(books, new ArrayList<>());
        Biblioteca bib = new Biblioteca(catalog);
        String msgUnsucessfullReturn = "That is not a valid book to return.";

        //when
        String actual = bib.returnABook(2);
        //then
        assertEquals(msgUnsucessfullReturn, actual);
        //when
        actual = bib.returnABook(3);
        //then
        assertEquals(msgUnsucessfullReturn, actual);

    }

    @Test
    public void showAvailableMoviesWithId() {
        //Given
        String expectedMovies = "(1) Movie 1\n";
        Catalog catalogMock = mock(Catalog.class);
        Biblioteca bib = new Biblioteca(catalogMock);
        Movie movie1 = mock(Movie.class);
        List<Movie> movies = new ArrayList<>();
        movies.add(movie1);

        //when
        when(movie1.getMovieId()).thenReturn(1);
        when(movie1.getTitle()).thenReturn("Movie 1");
        when(movie1.isAvailable()).thenReturn(true);
        when(catalogMock.listAllAvailableMovies()).thenReturn(movies);

        //then
        assertEquals(expectedMovies, bib.showAvailableMoviesWithId());
    }
}
