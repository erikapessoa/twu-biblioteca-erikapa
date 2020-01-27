package com.twu.biblioteca.model;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;

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
}
