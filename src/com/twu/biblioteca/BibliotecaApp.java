package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {


    public String welcomeMessage() {

        return "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangalore!";
    }

    public String listAllBooks() {
        String allBooks;
        List<Book> books = new ArrayList<>();

        books.add(new Book("Book1", "Author 1", Year.now()));
        books.add(new Book("Book2", "Author 2", Year.now()));
        books.add(new Book("Book3", "Author 3", Year.now()));
        books.add(new Book("Book4", "Author 4", Year.now()));

        allBooks = Util.formatBookListTitles(books);

        return allBooks;
    }

    public String listAllBooksWithAuthorAndYear() {
        List<Book> books = new ArrayList<>();
        String allBooks;

        books.add(new Book("Book1", "Author 1", Year.now()));
        books.add(new Book("Book2", "Author 2", Year.now()));
        books.add(new Book("Book3", "Author 3", Year.now()));
        books.add(new Book("Book4", "Author 4", Year.now()));

        allBooks = Util.formatBookListWithAuthorAndYear(books);

        return allBooks;
    }


    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();

        System.out.println("BIBLIOTECA BANGALORE");
        System.out.println(biblioteca.welcomeMessage());
        System.out.println(biblioteca.listAllBooksWithAuthorAndYear());
    }

}
