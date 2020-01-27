package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    private BibliotecaApp biblioteca = new BibliotecaApp();
    private  List<Book> expectedBooks;

    @Before
    public void initialize() {
        biblioteca.initializeBiblioteca();

        expectedBooks = new ArrayList<>();

        expectedBooks.add(new Book("Book1", "Author 1", Year.now()));
        expectedBooks.add(new Book("Book2", "Author 2", Year.now()));
        expectedBooks.add(new Book("Book3", "Author 3", Year.now()));
        expectedBooks.add(new Book("Book4", "Author 4", Year.now()));

    }

    @Test
    public void welcomeMessage() {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangalore!";

        assertEquals(welcomeMessage, biblioteca.welcomeMessage());
    }

    @Test
    public void listAllBooks(){
        String allBooks;

        assertEquals(expectedBooks, biblioteca.listAllBooks());

        allBooks = Util.formatBookListTitles(expectedBooks);

        assertEquals(allBooks, biblioteca.viewAllBooks());
    }

    @Test
    public void listAllBooksWithAuthorAndYear(){
        String allBooks;

        assertEquals(expectedBooks, biblioteca.listAllBooks());

        allBooks = Util.formatBookListWithAuthorAndYear(expectedBooks);

        assertEquals(allBooks, biblioteca.viewAllBooksWithAuthorAndYear());
    }


    @Test
    public void viewMainMenu() {
        String menuText = "Menu: choose an option: \n (1) List of Books\n";

        assertEquals(menuText, biblioteca.viewMainMenu());

        String userInput = "1";

        assertEquals(expectedBooks, biblioteca.menuChoice(userInput));

    }

}
