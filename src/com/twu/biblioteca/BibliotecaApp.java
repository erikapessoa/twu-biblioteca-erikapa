package com.twu.biblioteca;

import com.twu.biblioteca.controller.Biblioteca;
import com.twu.biblioteca.dao.Catalog;
import com.twu.biblioteca.dao.RegisteredUsers;
import com.twu.biblioteca.exceptions.InvalidLibraryNumberException;
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
        String option = "INVALID";

        while (!(option.equals("OK") || option.equals("GUEST"))) {
            try {
                option = tryToLogin(bibApp);
            } catch (InvalidLibraryNumberException e) {
                System.out.println("This is not a valid library number!");
            }
        }

        System.out.println(bibApp.showMainMenu());

        Scanner scan = new Scanner(System.in);
        String menuOption = scan.next();
        String itemId;

        while (!menuOption.equals("q")) {
            System.out.println(bibApp.chooseMenuOption(menuOption));

            if(bibApp.userIsLibrarian()) {
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
            }
            System.out.println(bibApp.showMainMenu());
            scan = new Scanner(System.in);
            menuOption = scan.next();
        }
    }

    private static void messageLogin() {
        System.out.println("If you wanna login type your library number; if not, type GUEST:");
    }


    private static String tryToLogin(Biblioteca bib) throws InvalidLibraryNumberException {
        String option;
        Scanner scan = new Scanner(System.in);
        String libraryNumber = scan.next();
        if (!libraryNumber.equals("GUEST") && Biblioteca.validLibraryNumberFormat(libraryNumber)) {
            System.out.println("Type your password:");
            scan = new Scanner(System.in);
            String pass = scan.next();
            bib.userLogin(libraryNumber, pass);
            option = "OK";
        }
         else if (libraryNumber.equals("GUEST")){
            option = libraryNumber;
        } else {
            System.out.println("This is not a valid option! Please, type your library number or type GUEST:");
            option = "INVALID";
        }
        return option;
    }

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
        users.add(new Librarian("001-0001", "1abcdef1"));
        users.add(new Librarian("001-0002", "2abcdef2"));
        users.add(new Customer("001-0003", "3abcdef3", "Customer One", "customer1@gmail.com", "123123123"));
        users.add(new Customer("001-0004", "4abcdef4", "Customer Two", "customer2@gmail.com", "213213213"));
        users.add(new Customer("001-0005", "5abcdef5", "Customer Three", "customer3@gmail.com", "321321321"));
        return users;
    }
}
