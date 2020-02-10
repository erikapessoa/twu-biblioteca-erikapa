package com.twu.biblioteca.exceptions;

public class MovieUnavailableException extends Exception {
    public MovieUnavailableException(){
        super("Sorry, that movie is not available");
    }
}
