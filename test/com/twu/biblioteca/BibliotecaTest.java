package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BibliotecaTest {

    private BibliotecaApp biblioteca = new BibliotecaApp();
    private  List<Book> allBooks;

    @Before
    public void initializeListOfAllBooks() {
        biblioteca.initializeBiblioteca();

        allBooks = new ArrayList<>();

        allBooks.add(new Book(1,"Book1", "Author 1", Year.now()));
        allBooks.add(new Book(2,"Book2", "Author 2", Year.now()));
        allBooks.add(new Book(3,"Book3", "Author 3", Year.now()));
        allBooks.add(new Book(4,"Book4", "Author 4", Year.now()));

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
    public void viewMainMenu() {
        String menuText = "Menu: choose an option: \n (1) List of Books\n (q) Quit";
        String invalidOption = "Please select a valid option!";
        String exit = "Bye!";

        assertEquals(menuText, biblioteca.viewMainMenu());
        String userInput = "1";
        assertEquals(Util.formatBookListTitles(allBooks), biblioteca.menuChoice(userInput));
        userInput = "2";
        assertEquals(invalidOption, biblioteca.menuChoice(userInput));
        userInput = "q";
        assertEquals(exit, biblioteca.menuChoice(userInput));
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

        //given - need a refactoring using mockito
        allBooks.get(0).setAvailable(false);
        biblioteca.checkoutABook(bookId);

        //then
        assertEquals(returnSuccessful, biblioteca.returnABook(bookId));



    }


}
