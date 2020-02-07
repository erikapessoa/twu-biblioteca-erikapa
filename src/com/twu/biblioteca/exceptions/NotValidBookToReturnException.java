package com.twu.biblioteca.exceptions;

public class NotValidBookToReturnException extends Exception {
    public NotValidBookToReturnException(){
        super("That is not a valid book to return.");
    }
}
