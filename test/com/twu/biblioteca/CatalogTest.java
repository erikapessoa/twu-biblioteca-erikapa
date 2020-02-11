package com.twu.biblioteca;

import com.twu.biblioteca.dao.Catalog;
import com.twu.biblioteca.exceptions.*;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.ItemType;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.Rate;
import org.junit.Test;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CatalogTest {

    @Test
    public void listAllBooks(){

        //Given
        List<Book> allBooks = new ArrayList<>();
        allBooks.add(new Book(1,"Book1", "Author 1", Year.now()));
        allBooks.add(new Book(2,"Book2", "Author 2", Year.now()));
        allBooks.add(new Book(3,"Book3", "Author 3", Year.now()));
        allBooks.add(new Book(4,"Book4", "Author 4", Year.now()));
        Catalog libraryCatalog = new Catalog(allBooks, new ArrayList<>());

        //when
        List<Book> actual = (List<Book>)libraryCatalog.listAll(ItemType.BOOK);

        //then
        assertEquals(allBooks, actual);
    }

    @Test
    public void listAllAvailableBooks(){

        //Given
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Book(1,"Book1", "Author 1", Year.now()));
        expectedBooks.add(new Book(2,"Book2", "Author 2", Year.now()));
        expectedBooks.get(0).setAvailable(false);
        Catalog libraryCatalog = new Catalog(expectedBooks, new ArrayList<>());
        expectedBooks.remove(0);

        //when
        List<Book> actual = (List<Book>) libraryCatalog.listAllAvailable(ItemType.BOOK);

        //then
        assertEquals(expectedBooks, actual);
    }

    @Test
    public void listAllBooksWithAuthorAndYear(){

        //Given
        List<Book> allBooks = new ArrayList<>();
        allBooks.add(new Book(1,"Book1", "Author 1", Year.now()));
        allBooks.add(new Book(2,"Book2", "Author 2", Year.now()));
        allBooks.add(new Book(3,"Book3", "Author 3", Year.now()));
        allBooks.add(new Book(4,"Book4", "Author 4", Year.now()));
        Catalog libraryCatalog = new Catalog(allBooks, new ArrayList<>());

        //when
        List<Book> actual = (List<Book>) libraryCatalog.listAll(ItemType.BOOK);

        //then
        for (Book book:
             actual) {
            assertNotNull(book.getAuthor());
            assertNotNull(book.getPublicationYear());
        }
    }

    @Test
    public void checkoutBook() {
        //Given
        List<Book> expectedAvailableBooks = new ArrayList<>();
        expectedAvailableBooks.add(new Book(1,"Book1", "Author 1", Year.now()));
        expectedAvailableBooks.add(new Book(2,"Book2", "Author 2", Year.now()));
        Catalog libraryCatalog = new Catalog(expectedAvailableBooks, new ArrayList<>());

        //when-then
        assertTrue(libraryCatalog.checkoutItem(ItemType.BOOK, 2));
    }

    @Test
    public void returnBook() throws NotValidItemToReturnException {
        //Given
        List<Book> expectedAvailableBooks = new ArrayList<>();
        expectedAvailableBooks.add(new Book(1,"Book1", "Author 1", Year.now()));
        expectedAvailableBooks.add(new Book(2,"Book2", "Author 2", Year.now()));
        expectedAvailableBooks.get(1).setAvailable(false);
        Catalog libraryCatalog = new Catalog(expectedAvailableBooks, new ArrayList<>());

        //when-then
        assertTrue(libraryCatalog.returnItem(ItemType.BOOK, 2));
    }

    @Test(expected = NotValidItemToReturnException.class)
    public void returnBook_whenExceptionThrow() throws NotValidItemToReturnException {
        //Given
        List<Book> expectedAvailableBooks = new ArrayList<>();
        expectedAvailableBooks.add(new Book(1,"Book1", "Author 1", Year.now()));
        expectedAvailableBooks.add(new Book(2,"Book2", "Author 2", Year.now()));
        Catalog libraryCatalog = new Catalog(expectedAvailableBooks, new ArrayList<>());

        libraryCatalog.returnItem(ItemType.BOOK, 3);
    }

    @Test
    public void listAllAvailableMovies(){

        //Given
        List<Movie> expectedMovies = new ArrayList<>();
        expectedMovies.add(new Movie(1, "Movie 1", "Director 1", Year.now(), Rate.EIGHT));
        expectedMovies.add(new Movie(2, "Movie 2", "Director 2", Year.now(), Rate.FIVE));
        expectedMovies.get(0).setAvailable(false);
        Catalog libraryCatalog = new Catalog(new ArrayList<>(), expectedMovies);
        expectedMovies.remove(0);

        //when
        List<Movie> actual = (List<Movie>) libraryCatalog.listAllAvailable(ItemType.MOVIE);

        //then
        assertEquals(expectedMovies, actual);
    }

    @Test
    public void checkoutMovie() {
        //Given
        List<Movie> expectedAvailableMovies = new ArrayList<>();
        expectedAvailableMovies.add(new Movie(1, "Movie 1", "Director 1", Year.now(), Rate.EIGHT));
        expectedAvailableMovies.add(new Movie(2, "Movie 2", "Director 2", Year.now(), Rate.FIVE));
        Catalog libraryCatalog = new Catalog(new ArrayList<>(), expectedAvailableMovies);

        //when-then
        assertTrue(libraryCatalog.checkoutItem(ItemType.MOVIE, 2));
    }
}