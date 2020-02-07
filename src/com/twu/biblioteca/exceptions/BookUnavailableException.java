package com.twu.biblioteca.exceptions;

public class BookUnavailableException extends Exception {

    public BookUnavailableException(){
        super("Sorry, that book is not available");
    }
}
