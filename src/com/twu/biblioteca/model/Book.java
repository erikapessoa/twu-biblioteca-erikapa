package com.twu.biblioteca.model;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Book {

    private String title;
    private String author;
    private Year publicationYear;

    public Book(String title, String author, Year publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Year getPublicationYear() {
        return publicationYear;
    }

    public String publicationYear() {
        return publicationYear.format(DateTimeFormatter.ofPattern("u"));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title) &&
                author.equals(book.author) &&
                publicationYear.equals(book.publicationYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publicationYear);
    }
}