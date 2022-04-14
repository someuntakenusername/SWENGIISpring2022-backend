package com.example.userGuide.Service;

import com.example.userGuide.model.User;
import com.example.userGuide.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public User createUser(User user){
        System.out.println(user);
        return userRepository.save(user);
    }

    public User userByLastname(String name) {
        List<User> users = this.userRepository.findAll();
        List<User> returned = new ArrayList<>();
        System.out.println(users);
        for (User user : users) {
            if (user.getLastName().equals(name)) {
                return user;
            }
        }
        return null;
    }

}
