package com.twu.biblioteca;

import com.twu.biblioteca.controller.Biblioteca;
import com.twu.biblioteca.dao.Catalog;
import com.twu.biblioteca.dao.RegisteredUsers;
import com.twu.biblioteca.exceptions.InvalidLibraryNumberException;
import com.twu.biblioteca.model.*;
import org.junit.Test;
import org.mockito.Mockito;

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
        RegisteredUsers users = mock(RegisteredUsers.class);
        Biblioteca bib = new Biblioteca(catalogMock, users);
        Book book1 = mock(Book.class);
        List<Book> books = new ArrayList<>();
        books.add(book1);

        //when
        when(book1.getTitle()).thenReturn("Book 1");
        Mockito.<List<? extends Item>>when(catalogMock.listAll(ItemType.BOOK)).thenReturn(books);

        //then
        assertEquals(expectedBooks, bib.showAllBooks());
    }

    @Test
    public void showListOfBooksWithAuthorAndYear() {
        //Given
        String expectedBooks = "Book 1 | Author 1 | 2015\n";
        Catalog catalogMock = mock(Catalog.class);
        RegisteredUsers users = mock(RegisteredUsers.class);
        Biblioteca bib = new Biblioteca(catalogMock, users);
        Book book1 = mock(Book.class);
        List<Item> books = new ArrayList<>();
        books.add(book1);

        //when
        when(book1.getTitle()).thenReturn("Book 1");
        when(book1.getAuthor()).thenReturn("Author 1");
        when(book1.publicationYear()).thenReturn("2015");
        Mockito.<List<? extends Item>>when(catalogMock.listAll(ItemType.BOOK)).thenReturn(books);

        //then
        assertEquals(expectedBooks, bib.showAllBooksWithAuthorAndYear());
    }

    @Test
    public void showAvailableBooksWithId() {
        //Given
        String expectedBooks = "(1) Book 1\n";
        Catalog catalogMock = mock(Catalog.class);
        RegisteredUsers users = mock(RegisteredUsers.class);
        Biblioteca bib = new Biblioteca(catalogMock, users);
        Book book1 = mock(Book.class);
        List<Book> books = new ArrayList<>();
        books.add(book1);

        //when
        when(book1.getBookId()).thenReturn(1);
        when(book1.getTitle()).thenReturn("Book 1");
        when(book1.isAvailable()).thenReturn(true);
        Mockito.<List<? extends Item>>when(catalogMock.listAllAvailable(ItemType.BOOK)).thenReturn(books);

        //then
        assertEquals(expectedBooks, bib.showAvailableBooksWithId());
    }

    @Test
    public void showMainMenuLibrarianLogeedIn() throws InvalidLibraryNumberException {
        //Given
        String expected = "(1) List of Books\n(2) Checkout a book\n(3) Return a book\n(4) List of Movies\n(5) Checkout a movie\n(q) Exit";
        String libraryNumber = "001-0001";
        String password = "a@23";
        User user = new Librarian(libraryNumber, password);
        List<User> users = new ArrayList<>();
        users.add(user);
        Catalog mockedCatalog = mock(Catalog.class);
        RegisteredUsers libraryUsers = new RegisteredUsers(users);
        Biblioteca bib = new Biblioteca(mockedCatalog, libraryUsers);

        //when
        bib.userLogin(libraryNumber, password);

        //then
        assertEquals(expected, bib.showMainMenu());
    }

    @Test
    public void showMainMenuUserNotLogeedIn() {
        //Given
        String expected = "(1) List of Books\n(4) List of Movies\n(q) Exit";
        Catalog mockedCatalog = mock(Catalog.class);
        RegisteredUsers mockedLibraryUsers = mock(RegisteredUsers.class);
        Biblioteca bib = new Biblioteca(mockedCatalog, mockedLibraryUsers);

        //when
        String actual = bib.showMainMenu();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void chooseInvalidMenuOption() {
        //Given
        String expected = "Please select a valid option!";
        Catalog catalog = mock(Catalog.class);
        RegisteredUsers users = mock(RegisteredUsers.class);
        Biblioteca bib = new Biblioteca(catalog, users);
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
        RegisteredUsers users = mock(RegisteredUsers.class);
        Biblioteca bib = new Biblioteca(catalog, users);
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
        RegisteredUsers users = mock(RegisteredUsers.class);
        Biblioteca bib = new Biblioteca(catalog, users);
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
        RegisteredUsers users = mock(RegisteredUsers.class);
        Biblioteca bib = new Biblioteca(catalog, users);
        String msgUnsucessfullChekout = "Sorry, that book is not available.";

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
        RegisteredUsers users = mock(RegisteredUsers.class);
        Biblioteca bib = new Biblioteca(catalog, users);
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
        RegisteredUsers users = mock(RegisteredUsers.class);
        Biblioteca bib = new Biblioteca(catalog, users);
        String msgUnsucessfullReturn = "That is not a valid book to return.";

        //when
        String actual = bib.returnABook(3);
        //then
        assertEquals(msgUnsucessfullReturn, actual);
    }

    @Test
    public void showAvailableMoviesWithId() {
        //Given
        String expectedMovies = "(1) Movie 1\n";
        Catalog catalogMock = mock(Catalog.class);
        RegisteredUsers users = mock(RegisteredUsers.class);
        Biblioteca bib = new Biblioteca(catalogMock, users);
        Movie movie1 = mock(Movie.class);
        List<Movie> movies = new ArrayList<>();
        movies.add(movie1);

        //when
        when(movie1.getMovieId()).thenReturn(1);
        when(movie1.getTitle()).thenReturn("Movie 1");
        when(movie1.isAvailable()).thenReturn(true);
        Mockito.<List<? extends Item>>when(catalogMock.listAllAvailable(ItemType.MOVIE)).thenReturn(movies);

        //then
        assertEquals(expectedMovies, bib.showAvailableMoviesWithId());
    }

    @Test
    public void checkoutAMovie() {
        //Given
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Movie 1", "Director 1", Year.now(), Rate.EIGHT));
        movies.add(new Movie(2, "Movie 2", "Director 2", Year.now(), Rate.FIVE));
        Catalog catalog = new Catalog(new ArrayList<>(), movies);
        RegisteredUsers users = mock(RegisteredUsers.class);
        Biblioteca bib = new Biblioteca(catalog, users);
        String msgSucessfulCheckout = "Thank you! Enjoy the movie.";

        //when
        String actual = bib.chekoutAMovie(2);

        //then
        assertEquals(msgSucessfulCheckout, actual);
    }

    @Test
    public void checkoutAMovieUnsuccessful() {
        //Given
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Movie 1", "Director 1", Year.now(), Rate.EIGHT));
        movies.add(new Movie(2, "Movie 2", "Director 2", Year.now(), Rate.FIVE));
        movies.get(1).setAvailable(false);
        Catalog catalog = new Catalog(new ArrayList<>(), movies);
        RegisteredUsers users = mock(RegisteredUsers.class);
        Biblioteca bib = new Biblioteca(catalog, users);
        String msgUnsucessfullChekout = "Sorry, that movie is not available.";

        //when
        String actual = bib.chekoutAMovie(2);

        //then
        assertEquals(msgUnsucessfullChekout, actual);
    }

    @Test
    public void userLogin() throws InvalidLibraryNumberException {
        //Given
        String libraryNumber = "001-0001";
        String password = "a@23";
        User user = new User(libraryNumber, password);
        List<User> users = new ArrayList<>();
        users.add(user);
        Catalog mockCatalog = mock(Catalog.class);
        RegisteredUsers libraryUsers = new RegisteredUsers(users);
        Biblioteca bib = new Biblioteca(mockCatalog, libraryUsers);

        //when-then
        assertTrue(bib.userLogin(libraryNumber, password));
    }

}
