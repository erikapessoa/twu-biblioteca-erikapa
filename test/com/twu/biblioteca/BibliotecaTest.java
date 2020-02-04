package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class BibliotecaTest {

    private BibliotecaApp biblioteca;

    @Before
    public void initializeBiblioteca() {
        biblioteca = new BibliotecaApp();
    }

    @Test
    public void welcomeMessage() {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangalore!";

        assertEquals(welcomeMessage, biblioteca.welcomeMessage());
    }

}
