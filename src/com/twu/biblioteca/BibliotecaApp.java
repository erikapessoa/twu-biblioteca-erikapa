package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {


    public String welcomeMessage() {

        return "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangalore!";
    }

    public String listAllBooks() {
        List<String> books = new ArrayList<String>();
        String allBooks;

        books.add("Book1");
        books.add("Book2");
        books.add("Book3");
        books.add("Book4");

        allBooks = String.join("\n", books);

        return allBooks;
    }

    public static void main(String[] args) {
        System.out.println("Hello, Biblioteca!");
    }

}
