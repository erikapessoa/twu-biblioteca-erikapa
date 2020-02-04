package com.twu.biblioteca;

import com.twu.biblioteca.dao.Catalog;
import com.twu.biblioteca.model.Book;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

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

}
