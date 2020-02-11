package com.twu.biblioteca;

import com.twu.biblioteca.controller.Biblioteca;
import com.twu.biblioteca.dao.Catalog;
import com.twu.biblioteca.dao.RegisteredUsers;
import com.twu.biblioteca.model.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        List<Book> books = getBooks();
        List<Movie> movies = getMovies();
        List<User> users = getUsers();
        Catalog catalog = new Catalog(books, movies);
        RegisteredUsers libraryUsers = new RegisteredUsers(users);
        Biblioteca bibApp = new Biblioteca(catalog, libraryUsers);

        System.out.println("BIBLIOTECA BANGALORE");
        System.out.println(Biblioteca.welcomeMessage());
        messageLogin();




        System.out.println(bibApp.showMainMenu());

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
            System.out.println(bibApp.showMainMenu());
            scan = new Scanner(System.in);
            menuOption = scan.next();
        }
    }

    private static void messageLogin() {
        System.out.println("If you wanna login type your library number; if not, type GUEST:");
    }

    /*
    private String tryToLogin(Biblioteca bib) {
        Scanner scan = new Scanner(System.in);
        String option = scan.next();
        if (!option.equals("GUEST") && RegisteredUsers.validLibraryNumberFormat(option)) {
            boolean exist = bib.registeredUser(option);
            if(exist) {
                scan = new Scanner(System.in);
                String pass = scan.next();
                bib.userLogin(option, pass);
                option = "OK";
            }
        } else if (option.equals("GUEST")){
            return option;
        } else
            option = "INVALID";

        return option;
    }

     */

    private static List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Movie 1", "Director 1", Year.now(), Rate.EIGHT));
        movies.add(new Movie(2, "Movie 2", "Director 2", Year.now(), Rate.FIVE));
        movies.add(new Movie(3, "Movie 3", "Director 3", Year.now(), Rate.SEVEN));
        return movies;
    }

    private static List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"Book1", "Author 1", Year.now()));
        books.add(new Book(2,"Book2", "Author 2", Year.now()));
        books.add(new Book(3,"Book3", "Author 3", Year.now()));
        books.add(new Book(4,"Book4", "Author 4", Year.now()));
        return books;
    }

    private static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("000-00001", "1abcdef1"));
        users.add(new User("000-00002", "2abcdef2"));
        users.add(new User("000-00003", "3abcdef3"));
        users.add(new User("000-00004", "4abcdef4"));
        users.add(new User("000-00005", "5abcdef5"));
        return users;
    }
}
