package com.twu.biblioteca.exceptions;

public class InvalidLibraryNumberException extends Exception {
    public InvalidLibraryNumberException(){
        super("The library number needs to be in the format xxx-xxxx");
    }
}
