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

        books.add(new Book("Book1", "Author 1", Year.now()));
        books.add(new Book("Book2", "Author 2", Year.now()));
        books.add(new Book("Book3", "Author 3", Year.now()));
        books.add(new Book("Book4", "Author 4", Year.now()));
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

        return "Menu: choose an option: \n (1) List of Books\n";
    }

    public String menuChoice(String userInput) {
        if(userInput.equals("1"))
            return viewAllBooks();
        else
            return "Please select a valid option!";
    }

    /*
    public String viewMainMenu() {
        
    }
     */
}
