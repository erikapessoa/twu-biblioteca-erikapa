package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {


    public String welcomeMessage() {

        return "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangalore!";
    }

    public String listAllBooks() {
        List<String> books = new ArrayList<>();
        String allBooks;

        books.add("Book1");
        books.add("Book2");
        books.add("Book3");
        books.add("Book4");

        allBooks = String.join("\n", books);

        return allBooks;
    }

    public String listAllBooksWithAuthorAndYear() {
        List<String> books = new ArrayList<>();
        String allBooks;

        books.add("Book1 | Author 1 | Year 1 ");
        books.add("Book2 | Author 2 | Year 2 ");
        books.add("Book3 | Author 3 | Year 3 ");
        books.add("Book4 | Author 4 | Year 4 ");

        allBooks = String.join("\n", books);

        return allBooks;
    }


    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();

        System.out.println("BIBLIOTECA BANGALORE");
        System.out.println(biblioteca.welcomeMessage());
        System.out.println(biblioteca.listAllBooksWithAuthorAndYear());
    }

}
