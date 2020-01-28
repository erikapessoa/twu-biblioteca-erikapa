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

    public String viewAllBooks() {
        String allBooks;

        allBooks = Util.formatBookListTitles(books);

        return allBooks;
    }

    public String viewAllBooksWithAuthorAndYear() {
        String allBooks;

        allBooks = Util.formatBookListWithAuthorAndYear(books);

        return allBooks;
    }

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();

        System.out.println("BIBLIOTECA BANGALORE");
        System.out.println(biblioteca.welcomeMessage());
        System.out.println(biblioteca.viewAllBooksWithAuthorAndYear());
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

    public List<Book> checkoutABook(int bookId) {
        List<Book> availableBooks = new ArrayList<>(books);
        if(returnBookWithId(bookId) != null)
            availableBooks.remove(returnBookWithId(bookId));
        return availableBooks;
    }

    private Book returnBookWithId(int bookId) {
        for (Book book:
             books) {
            if (book.getBookId().equals(bookId))
                return book;
        }
        return null;
    }
}
