package com.twu.biblioteca.exceptions;

public class NotValidBookToReturnException extends NotValidItemToReturnException {
    public NotValidBookToReturnException(){
        super("That is not a valid book to return.");
    }
}
