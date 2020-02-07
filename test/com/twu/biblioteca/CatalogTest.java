package com.twu.biblioteca;

import com.twu.biblioteca.dao.Catalog;
import com.twu.biblioteca.exceptions.NotValidBookToReturnException;
import com.twu.biblioteca.exceptions.BookUnavailableException;
import com.twu.biblioteca.model.Book;
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
        Catalog libraryCatalog = new Catalog(allBooks);

        //when
        List<Book> actual = libraryCatalog.listAllBooks();

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
        Catalog libraryCatalog = new Catalog(expectedBooks);
        expectedBooks.remove(0);

        //when
        List<Book> actual = libraryCatalog.listAllAvailableBooks();

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
        Catalog libraryCatalog = new Catalog(allBooks);

        //when
        List<Book> actual = libraryCatalog.listAllBooks();

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
        Catalog libraryCatalog = new Catalog(expectedAvailableBooks);
        //when
        try {
            libraryCatalog.checkoutBook(2);
        } catch (BookUnavailableException e) {
            assertTrue(libraryCatalog.listAllBooks().get(1).isAvailable());
        }
        //then
        assertFalse(libraryCatalog.listAllBooks().get(1).isAvailable());
    }

    @Test
    public void returnBook() {
        //Given
        List<Book> expectedAvailableBooks = new ArrayList<>();
        expectedAvailableBooks.add(new Book(1,"Book1", "Author 1", Year.now()));
        expectedAvailableBooks.add(new Book(2,"Book2", "Author 2", Year.now()));
        expectedAvailableBooks.get(1).setAvailable(false);
        Catalog libraryCatalog = new Catalog(expectedAvailableBooks);

        //when
        try {
            libraryCatalog.returnBook(2);
        } catch (NotValidBookToReturnException e) {
            assertFalse(libraryCatalog.listAllBooks().get(1).isAvailable());
        }
        //then
        assertTrue(libraryCatalog.listAllBooks().get(1).isAvailable());
    }
}