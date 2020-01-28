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
    private  List<Book> allBooks;

    @Before
    public void initialize() {
        biblioteca.initializeBiblioteca();

        allBooks = new ArrayList<>();

        allBooks.add(new Book("Book1", "Author 1", Year.now()));
        allBooks.add(new Book("Book2", "Author 2", Year.now()));
        allBooks.add(new Book("Book3", "Author 3", Year.now()));
        allBooks.add(new Book("Book4", "Author 4", Year.now()));

    }

    @Test
    public void welcomeMessage() {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangalore!";

        assertEquals(welcomeMessage, biblioteca.welcomeMessage());
    }

    @Test
    public void listAllBooks(){
        String allBooks;

        assertEquals(this.allBooks, biblioteca.listAllBooks());

        allBooks = Util.formatBookListTitles(this.allBooks);

        assertEquals(allBooks, biblioteca.viewAllBooks());
    }

    @Test
    public void listAllBooksWithAuthorAndYear(){
        String allBooks;

        assertEquals(this.allBooks, biblioteca.listAllBooks());

        allBooks = Util.formatBookListWithAuthorAndYear(this.allBooks);

        assertEquals(allBooks, biblioteca.viewAllBooksWithAuthorAndYear());
    }


    @Test
    public void viewMainMenu() {
        String menuText = "Menu: choose an option: \n (1) List of Books\n";
        String invalidOption = "Please select a valid option!";

        assertEquals(menuText, biblioteca.viewMainMenu());

        String userInput = "1";

        assertEquals(Util.formatBookListTitles(allBooks), biblioteca.menuChoice(userInput));

        userInput = "2";

        assertEquals(invalidOption, biblioteca.menuChoice(userInput));
    }

}
