package com.twu.biblioteca.util;

import com.twu.biblioteca.model.Book;

import java.util.List;

public class Util {

    public static String formatBookListWithAuthorAndYear(List<Book> books ) {
        StringBuilder allBooks = new StringBuilder();

        for (Book book: books
             ) {
            allBooks.append(book.getTitle()).append(" | ").append(book.getAuthor()).append(" | ").append(book.publicationYear()).append("\n");
        }

        return allBooks.toString();
    }

    public static String formatBookListTitles(List<Book> books ) {
        StringBuilder allBooks = new StringBuilder();

        for (Book book: books
        ) {
            allBooks.append(book.getTitle()).append("\n");
        }

        return allBooks.toString();
    }
}
