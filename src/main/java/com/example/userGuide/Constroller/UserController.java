package com.example.userGuide.Constroller;

import com.example.userGuide.Forumns.CreateUserForumn;
import com.example.userGuide.Service.UserService;
import com.example.userGuide.model.User;
import com.example.userGuide.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
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

    @RequestMapping(value = "/createuser", method = RequestMethod.POST)
    public User updateAdmission(@RequestBody CreateUserForumn createUserForumn) {
        System.out.println(createUserForumn);
        return userService.createUser(new User(createUserForumn.getNameFirst(), createUserForumn.getNameLast(), createUserForumn.getEmail(), createUserForumn.getPassword()));
    }
}


