package com.twu.biblioteca.exceptions;

public class BookUnavailableException extends ItemUnavailableException {

    public BookUnavailableException(){
        super("Sorry, that book is not available");
    }
}
