package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;

import java.io.Console;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {


    public String welcomeMessage() {

        return "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangalore!";
    }

    /*

    public String viewAllBooks() {
        String allBooks;

        allBooks = Util.formatBookListTitles(mBooks);

        return allBooks;
    }

    public String viewAllAvailableBooks() {
        String allBooks;

        allBooks = Util.formatBookListTitles(listAllAvailableBooks());

        return allBooks;
    }

    public String viewAllBooksWithAuthorAndYear() {
        String allBooks;

        allBooks = Util.formatBookListWithAuthorAndYear(mBooks);

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
                menuText = viewAllAvailableBooks();
                break;
            case "q":
                menuText = "Bye!";
                break;
            default:
                menuText = "Please select a valid option!";
        }


        return menuText;
    }
*/

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();

        /*
        biblioteca.initializeBiblioteca();
        System.out.println("BIBLIOTECA BANGALORE");
        System.out.println(biblioteca.welcomeMessage());
        System.out.println(biblioteca.viewMainMenu());
        Scanner scan = new Scanner(System.in);
        String menuOption = scan.next();
        System.out.println(biblioteca.menuChoice(menuOption));
        */
    }
}
