package com.example.userGuide.Constroller;

import com.example.userGuide.Service.UserService;
import com.example.userGuide.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserControllerTest {
    @Autowired
    private UserService userService;

    @Test
    void getUsers() {
        assertThat(userService.getUsers()).isNotNull();
    }

    @Test
    void updateAdmission() {
        assertThat(userService.createUser(new User("john", "doe", "iamthechowderman@hotmail.org", "rosebud")).equals(new User("john", "doe", "iamthechowderman@hotmail.org", "rosebud")));
    }

    @Test
    void searchByLastName() {
        assertThat(userService.userByLastname("doe").equals(new User("john", "doe", "iamthechowderman@hotmail.org", "rosebud")));
    }
}