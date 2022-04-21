package com.example.userGuide.Constroller;

import com.example.userGuide.Forumns.CreateUserForumn;
import com.example.userGuide.Service.UserService;
import com.example.userGuide.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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
    public User searchByLastName(@PathVariable("name") Object name) {
        return userService.userByLastname((String)name);
    }

    @RequestMapping(value = "/createuser", method = RequestMethod.POST)
    public User updateAdmission(@RequestBody CreateUserForumn createUserForumn) {
        System.out.println(createUserForumn);
        return userService.createUser(new User(createUserForumn.getNameFirst(), createUserForumn.getNameLast(), createUserForumn.getEmail(), createUserForumn.getPassword()));
    }
}


