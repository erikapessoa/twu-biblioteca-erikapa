package com.twu.biblioteca.exceptions;

public class BookUnavailableException extends Exception {

    public BookUnavailableException(){
        super("Sorry, this book is not available");
    }
}
