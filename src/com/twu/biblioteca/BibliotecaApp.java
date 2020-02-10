package com.twu.biblioteca;

import com.twu.biblioteca.controller.Biblioteca;
import com.twu.biblioteca.dao.Catalog;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.Rate;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"Book1", "Author 1", Year.now()));
        books.add(new Book(2,"Book2", "Author 2", Year.now()));
        books.add(new Book(3,"Book3", "Author 3", Year.now()));
        books.add(new Book(4,"Book4", "Author 4", Year.now()));
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Movie 1", "Director 1", Year.now(), Rate.EIGHT));
        movies.add(new Movie(2, "Movie 2", "Director 2", Year.now(), Rate.FIVE));
        movies.add(new Movie(3, "Movie 3", "Director 3", Year.now(), Rate.SEVEN));
        Catalog catalog = new Catalog(books, movies);
        Biblioteca bibApp = new Biblioteca(catalog);

        System.out.println("BIBLIOTECA BANGALORE");
        System.out.println(Biblioteca.welcomeMessage());
        System.out.println(Biblioteca.showMainMenu());

        Scanner scan = new Scanner(System.in);
        String menuOption = scan.next();
        String itemId;

        while (!menuOption.equals("q")) {
            System.out.println(bibApp.chooseMenuOption(menuOption));

            switch (menuOption) {
                case "2":
                    scan = new Scanner(System.in);
                    itemId = scan.next();
                    System.out.println(bibApp.chekoutABook(Integer.parseInt(itemId)));
                    break;
                case "3":
                    scan = new Scanner(System.in);
                    itemId = scan.next();
                    System.out.println(bibApp.returnABook(Integer.parseInt(itemId)));
                    break;
                case "5":
                    scan = new Scanner(System.in);
                    itemId = scan.next();
                    System.out.println(bibApp.chekoutAMovie(Integer.parseInt(itemId)));
                    break;
                default:
                     System.out.println("\n");
            }
            System.out.println("Choose an option: \n");
            System.out.println(Biblioteca.showMainMenu());
            scan = new Scanner(System.in);
            menuOption = scan.next();
        }
    }
}
