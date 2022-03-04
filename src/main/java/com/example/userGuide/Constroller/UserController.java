package com.example.userGuide.Constroller;

import com.example.userGuide.Service.UserService;
import com.example.userGuide.model.User;
import com.example.userGuide.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("user/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{name}")
    public List<User> searchByLastName(@PathVariable("name") String name) {
        return userService.userByLastname(name);
    }

    @PostMapping("post")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}


