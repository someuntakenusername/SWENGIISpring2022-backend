package com.example.userGuide.Constroller;

import com.example.userGuide.Service.UserService;
import com.example.userGuide.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest {

    @Autowired
    private UserService userService;

    @Test
    void createUserWorks() {
        User newUser = new User("Eunjee", "Song", "esong@blueflannel.com", "song");
        assertNotNull(userService.createUser(newUser));
        userService.removeUser(newUser.getId());
    }

    @Test
    void createDuplicateUser() {
        User newUser1 = new User("Eunjee", "Song", "esong@blueflannel.com", "song");
        User newUser2 = new User("Eunjee", "Song", "esong@blueflannel.com", "song");
        userService.createUser(newUser1);
        assertNotNull(userService.createUser(newUser2));
        userService.removeUser(newUser1.getId());
        userService.removeUser(newUser2.getId());
    }

    @Test
    void removeExistingUser() {
        User newUser = new User("Eunjee", "Song", "esong@blueflannel.com", "song");
        userService.createUser(newUser);
        assertNotNull(userService.removeUser(newUser.getId()));
        userService.removeUser(newUser.getId());
    }

    @Test
    void removeNonExistingUser() {
        assertNull(userService.removeUser(0));
    }

    @Test
    void findExisitngUserByLastName() {
        User newUser = new User("Eunjee", "Song", "esong@blueflannel.com", "song");
        userService.createUser(newUser);
        assertNotNull(userService.userByLastname(newUser.getLastName()));
        userService.removeUser(newUser.getId());
    }

    @Test
    void findNonExisitngUserByLastName() {
        assertNull(userService.userByLastname("Song"));
    }

    @Test
    void getUsers() {
        User newUser = new User("Eunjee", "Song", "esong@blueflannel.com", "song");
        userService.createUser(newUser);
        assertThat(userService.getUsers()).isNotNull();
        userService.removeUser(newUser.getId());
    }
}