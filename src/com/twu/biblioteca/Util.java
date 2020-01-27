package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;

import java.util.List;

public class Util {

    public static String formatBookListWithAuthorAndYear(List<Book> books ) {
        String allBooks = "";

        for (Book book: books
             ) {
            allBooks = allBooks + book.getTitle() + " | " + book.getAuthor() + " | " +
                    book.publicationYear() + "\n";
        }

        return allBooks;
    }

    public static String formatBookListTitles(List<Book> books ) {
        String allBooks = "";

        for (Book book: books
        ) {
            allBooks = allBooks + book.getTitle() + "\n";
        }

        return allBooks;
    }
}
