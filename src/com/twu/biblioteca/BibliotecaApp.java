package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {


    private List<Book> books = new ArrayList<>();

    public String welcomeMessage() {

        return "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangalore!";
    }

    public void initializeBiblioteca() {

        books = new ArrayList<>();

        books.add(new Book(1,"Book1", "Author 1", Year.now()));
        books.add(new Book(2,"Book2", "Author 2", Year.now()));
        books.add(new Book(3,"Book3", "Author 3", Year.now()));
        books.add(new Book(4,"Book4", "Author 4", Year.now()));
    }

    public List<Book> listAllBooks() {
        return books;
    }

    public List<Book> listAllAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>(books);

        availableBooks.removeIf(book -> !book.isAvailable());
        return availableBooks;
    }

    public String viewAllBooks() {
        String allBooks;

        allBooks = Util.formatBookListTitles(books);

        return allBooks;
    }

    public String viewAllAvailableBooks() {
        String allBooks;

        allBooks = Util.formatBookListTitles(listAllAvailableBooks());

        return allBooks;
    }

    public String viewAllBooksWithAuthorAndYear() {
        String allBooks;

        allBooks = Util.formatBookListWithAuthorAndYear(books);

        return allBooks;
    }

    public String viewAllAvailableBooksWithAuthorAndYear() {
        String allBooks;

        allBooks = Util.formatBookListWithAuthorAndYear(listAllAvailableBooks());

        return allBooks;
    }

    public String viewMainMenu() {

        return "Menu: choose an option: \n (1) List of Books\n (q) Quit";
    }

    public String menuChoice(String userInput) {
        String menuText;

        switch (userInput) {
            case "1":
                menuText = viewAllBooks();
                break;
            case "q":
                menuText = "Bye!";
                break;
            default:
                menuText = "Please select a valid option!";
        }
        return menuText;
    }

    public String checkoutABook(int bookId) {
        String checkoutSuccessful = "Thank you! Enjoy the book.";
        String checkoutUnsuccessful = "Sorry, that book is not available.";
        Book choosedBook = findBookWithId(bookId);

        if(choosedBook.isAvailable()) {
            choosedBook.setAvailable(false);
            return checkoutSuccessful;
        } else
            return checkoutUnsuccessful;
    }

    public String returnABook(int bookId) {

        String returnSuccessful = "Thank you for returning the book.";
        Book returnedBook = findBookWithId(bookId);

        if(!returnedBook.isAvailable()) {
            returnedBook.setAvailable(true);
            return returnSuccessful;
        }
        return "0";
    }

    private Book findBookWithId(int bookId) {
        for (Book book:
             books) {
            if (book.getBookId().equals(bookId))
                return book;
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();

        System.out.println("BIBLIOTECA BANGALORE");
        System.out.println(biblioteca.welcomeMessage());
        System.out.println(biblioteca.viewAllBooksWithAuthorAndYear());
    }
}
