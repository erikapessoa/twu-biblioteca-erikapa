package com.twu.biblioteca;

import com.twu.biblioteca.dao.Catalog;
import com.twu.biblioteca.model.Book;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

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

    /*

    @Test
    public void listAllAvailableBooks(){
        String allBooks;

        assertEquals(this.allBooks, biblioteca.listAllAvailableBooks());

        allBooks = Util.formatBookListTitles(this.allBooks);

        assertEquals(allBooks, biblioteca.viewAllAvailableBooks());
    }

    @Test
    public void listAllBooksWithAuthorAndYear(){
        String allBooks;

        assertEquals(this.allBooks, biblioteca.listAllAvailableBooks());

        allBooks = Util.formatBookListWithAuthorAndYear(this.allBooks);

        assertEquals(allBooks, biblioteca.viewAllAvailableBooksWithAuthorAndYear());
    }


    @Test
    public void checkoutABook() {
        int bookId = 1;
        String checkoutSuccessful = "Thank you! Enjoy the book.";
        String checkoutUnsuccessful = "Sorry, that book is not available.";

        assertEquals(checkoutSuccessful, biblioteca.checkoutABook(bookId));
        assertEquals(checkoutUnsuccessful, biblioteca.checkoutABook(bookId));
    }

    @Test
    public void returnABook() {
        int bookId = 1;
        String returnSuccessful = "Thank you for returning the book.";
        String returnUnsuccessful = "That is not a valid book to return.";

        //given - need a refactoring using mockito
        allBooks.get(0).setAvailable(false);
        biblioteca.checkoutABook(bookId);

        //then
        assertEquals(returnSuccessful, biblioteca.returnABook(bookId));

        bookId = 5;

        assertEquals(returnUnsuccessful, biblioteca.returnABook(bookId));
    }
    */
}
