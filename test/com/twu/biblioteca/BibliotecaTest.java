package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import org.junit.Test;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    private BibliotecaApp biblioteca = new BibliotecaApp();

    @Test
    public void bibliotecaWelcomeMessage() {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangalore!";

        assertEquals(welcomeMessage, biblioteca.welcomeMessage());
    }

    @Test
    public void bibliotecaListAllBooks(){
        String allBooks;
        List<Book> books = new ArrayList<>();

        books.add(new Book("Book1", "Author 1", Year.now()));
        books.add(new Book("Book2", "Author 2", Year.now()));
        books.add(new Book("Book3", "Author 3", Year.now()));
        books.add(new Book("Book4", "Author 4", Year.now()));

        allBooks = Util.formatBookListTitles(books);

        assertEquals(allBooks, biblioteca.listAllBooks());
    }

    @Test
    public void bibliotecaListAllBooksWithAuthorAndYear(){
        String allBooks;
        List<Book> books = new ArrayList<>();

        books.add(new Book("Book1", "Author 1", Year.now()));
        books.add(new Book("Book2", "Author 2", Year.now()));
        books.add(new Book("Book3", "Author 3", Year.now()));
        books.add(new Book("Book4", "Author 4", Year.now()));

        allBooks = Util.formatBookListWithAuthorAndYear(books);

        assertEquals(allBooks, biblioteca.listAllBooksWithAuthorAndYear());
    }

}
