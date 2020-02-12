package com.twu.biblioteca;

import com.twu.biblioteca.dao.RegisteredUsers;
import com.twu.biblioteca.exceptions.InvalidLibraryNumberException;
import com.twu.biblioteca.model.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RegisteredUsersTest {

    @Test
    public void findUserById() throws InvalidLibraryNumberException {
        //Given
        User user1 =  new User("000-0001", "abcdefg");
        User user2 =  new User("000-0002", "gfedcba");
        List<User> users =  new ArrayList<>();
        users.add(user1);
        users.add(user2);
        String libraryNumber = "000-0001";
        RegisteredUsers regUsers = new RegisteredUsers(users);

        assertEquals(user1, regUsers.findUserById(libraryNumber));
    }

    @Test
    public void correctPassword() {
        //Given
        User user1 =  new User("000-0001", "abcdefg");
        User user2 =  new User("000-0002", "gfedcba");
        List<User> users =  new ArrayList<>();
        users.add(user1);
        users.add(user2);
        String libraryNumber = "000-0001";
        String password = "abcdefg";
        RegisteredUsers regUsers = new RegisteredUsers(users);

        //when-then
        assertTrue(regUsers.correctPassword(libraryNumber, password));
    }

    @Test
    public void validLibraryNumberFormat() throws InvalidLibraryNumberException {
        //Given
        String libraryNumber = "000-0001";
        //when
        assertTrue(RegisteredUsers.validLibraryNumberFormat(libraryNumber));
    }

    @Test(expected = InvalidLibraryNumberException.class)
    public void validLibraryNumberFormat_whenExceptionThrow() throws InvalidLibraryNumberException {
        //Given
        String libraryNumber = "001-001a";

        RegisteredUsers.validLibraryNumberFormat(libraryNumber);
    }
}
