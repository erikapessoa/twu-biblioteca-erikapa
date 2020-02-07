package com.twu.biblioteca;

import com.twu.biblioteca.controller.Biblioteca;
import com.twu.biblioteca.dao.Catalog;
import com.twu.biblioteca.exceptions.BookUnavailableException;
import com.twu.biblioteca.model.Book;
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
    public void showMainMenu() {
        //Given
        String expected = "(1) List of Books";
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
        List<Book> expectedAvailableBooks = new ArrayList<>();
        expectedAvailableBooks.add(new Book(1,"Book1", "Author 1", Year.now()));
        expectedAvailableBooks.add(new Book(2,"Book2", "Author 2", Year.now()));
        expectedAvailableBooks.get(1).setAvailable(false);
        Catalog mockCatalog = mock(Catalog.class);
        Biblioteca bib = new Biblioteca(mockCatalog);

        //when
        when(mockCatalog.listAllAvailableBooks()).thenReturn(expectedAvailableBooks);

        //then
        assertEquals(expectedAvailableBooks, bib.chekoutABook(2));
    }
}
