package com.twu.biblioteca.exceptions;

public class MovieUnavailableException extends ItemUnavailableException {
    public MovieUnavailableException(){
        super("Sorry, that movie is not available");
    }
}
