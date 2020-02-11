package com.twu.biblioteca.util;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.model.Movie;

import java.util.List;

public class Util {

    public static String formatBookListWithAuthorAndYear(List<? extends Item> books ) {
        StringBuilder allBooks = new StringBuilder();

        for (Book book: (List<Book>) books) {
            allBooks.append(book.getTitle()).append(" | ").append(book.getAuthor()).append(" | ").append(book.publicationYear()).append("\n");
        }

        return allBooks.toString();
    }

    public static String formatBookListTitles(List<? extends Item> books ) {
        StringBuilder allBooks = new StringBuilder();

        for (Book book: (List<Book>) books) {
            allBooks.append(book.getTitle()).append("\n");
        }

        return allBooks.toString();
    }

    public static String formatBookListWithTitleAndId(List<? extends Item> books ) {
        StringBuilder allBooks = new StringBuilder();

        for (Book book: (List<Book>) books) {
            allBooks.append("(").
                    append(book.getBookId()).
                    append(") ").
                    append(book.getTitle()).
                    append("\n");
        }
        return allBooks.toString();
    }

    public static String formatMovieListWithTitleAndId(List<? extends Item> movies ) {
        StringBuilder allMovies = new StringBuilder();

        for (Movie movie: (List<Movie>) movies
        ) {
            allMovies.append("(").
                    append(movie.getMovieId()).
                    append(") ").
                    append(movie.getTitle()).
                    append("\n");
        }
        return allMovies.toString();
    }

    public static boolean isNumeric(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
