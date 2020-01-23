package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    private BibliotecaApp biblioteca = new BibliotecaApp();

    @Test
    public void bibliotecaWelcomeMessage() {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangalore!";

        assertEquals(welcomeMessage, biblioteca.welcomeMessage());
    }

    @Test
    public void bibliotecaListAllBooks(){
        String allBooks = "Book1\nBook2\nBook3\nBook4";

        assertEquals(allBooks, biblioteca.listAllBooks());
    }
}
