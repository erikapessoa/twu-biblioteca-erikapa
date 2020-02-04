package com.twu.biblioteca.view;

import com.twu.biblioteca.Util;
import com.twu.biblioteca.dao.Catalog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;


public class Menu {
    private Hashtable<Integer,String> options;
    private Catalog catalog;

    public Menu() {
        this.options = new Hashtable<>();
        catalog = new Catalog();
    }

    public Menu(Hashtable<Integer, String> options) {
        this.options = new Hashtable<>(options);
        catalog = new Catalog();
    }

    public void addMenuOption(Integer key, String opcao) {
        options.put(key, opcao);
    }

    public List<String> listMenuOptions() {
        return new ArrayList<>(options.values());
    }


    public String chooseMenuOption(String menuChoice) {
        String menuText;

        switch (menuChoice) {
            case "1":
                menuText = Util.formatBookListTitles(catalog.listAllBooks());
                break;
            default:
                menuText = "Please select a valid option!";
        }

        return menuText;

    }
}
