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

    /*
    @Test
    public void viewMainMenu() {
        String menuText = "Menu: choose an option: \n (1) List of Books\n (q) Quit";
        String invalidOption = "Please select a valid option!";
        String exit = "Bye!";

        assertEquals(menuText, biblioteca.viewMainMenu());
        String userInput = "1";
        assertEquals(Util.formatBookListTitles(allBooks), biblioteca.menuChoice(userInput));
        userInput = "2";
        assertEquals(invalidOption, biblioteca.menuChoice(userInput));
        userInput = "q";
        assertEquals(exit, biblioteca.menuChoice(userInput));
    }
    */

    @Test
    public void welcomeMessage() {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangalore!";

        assertEquals(welcomeMessage, biblioteca.welcomeMessage());
    }

}
