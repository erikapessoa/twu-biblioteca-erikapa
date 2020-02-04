package com.twu.biblioteca.dao;

import com.twu.biblioteca.model.Book;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private List<Book> mBooks;

    public Catalog()  {
        mBooks = new ArrayList<>();
        mBooks.add(new Book(1,"Book1", "Author 1", Year.now()));
        mBooks.add(new Book(2,"Book2", "Author 2", Year.now()));
        mBooks.add(new Book(3,"Book3", "Author 3", Year.now()));
        mBooks.add(new Book(4,"Book4", "Author 4", Year.now()));

    }

    public Catalog(List<Book> books)  {
        mBooks = new ArrayList<>(books);
    }

    public List<Book> listAllBooks() {
        return mBooks;
    }

}
