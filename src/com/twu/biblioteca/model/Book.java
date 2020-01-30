package com.twu.biblioteca.model;

import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Book {

    private Integer bookId;
    private String title;
    private String author;
    private Year publicationYear;
    private boolean available;


    public Book(Integer bookId, String title, String author, Year publicationYear) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        available = true;
    }

    public Integer getBookId() {
        return bookId;
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId.equals(book.bookId) &&
                title.equals(book.title) &&
                author.equals(book.author) &&
                publicationYear.equals(book.publicationYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, author, publicationYear);
    }
}
