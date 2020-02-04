package com.twu.biblioteca;

import com.twu.biblioteca.dao.Catalog;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.view.Menu;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.time.Year;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class MenuTest {

    @Test
    public void addMenuOption() {
        //Given
        String menuOption = "List of Books";
        Menu menu = new Menu();

        //when
        menu.addMenuOption(1, menuOption);
        List<String> menuOptions = menu.listMenuOptions();

        //then
        assertThat(menuOptions, hasItem(menuOption));
    }

    @Test
    public void viewMainMenu() {
        //Given
        String menuOption = "List of Books";
        Hashtable options = new Hashtable();
        options.put(1,menuOption);
        Menu menu = new Menu(options);

        //when
        List<String> option = menu.listMenuOptions();

        //then
        assertEquals(menuOption, option.get(0));
    }
    @Test
    public void viewListOfBooks() {
        //Given
        String menuOption = "List of Books";
        Hashtable options = new Hashtable();
        options.put(1,menuOption);
        Menu menu = new Menu(options);

        List<Book> allBooks = new ArrayList<>();
        allBooks.add(new Book(1,"Book1", "Author 1", Year.now()));
        allBooks.add(new Book(2,"Book2", "Author 2", Year.now()));
        allBooks.add(new Book(3,"Book3", "Author 3", Year.now()));
        allBooks.add(new Book(4,"Book4", "Author 4", Year.now()));

        //when
       String listOfAllBooks = menu.chooseMenuOption("1");

        //then
        assertEquals(Util.formatBookListTitles(allBooks), listOfAllBooks);
    }

    @Test
    public void invalidMenuOption() {
        //Given
        String menuOption = "List of Books";
        Hashtable options = new Hashtable();
        options.put(1,menuOption);
        Menu menu = new Menu(options);

        //when
        List<String> option = menu.listMenuOptions();

        //then
        assertEquals(menuOption, option.get(0));
    }
}

//String menuText = "Menu: choose an option: \n (1) List of Books\n (q) Quit";
//String invalidOption = "Please select a valid option!";
//String exit = "Bye!";

//assertEquals(menuText, biblioteca.viewMainMenu());
//String userInput = "1";
//assertEquals(Util.formatBookListTitles(allBooks), biblioteca.menuChoice(userInput));
//userInput = "2";
//assertEquals(invalidOption, biblioteca.menuChoice(userInput));
//userInput = "q";
//assertEquals(exit, biblioteca.menuChoice(userInput));
