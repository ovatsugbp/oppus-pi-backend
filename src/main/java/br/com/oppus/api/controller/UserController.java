package br.com.oppus.api.controller;

import br.com.oppus.api.model.entities.User;
import br.com.oppus.api.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public Iterable<User> getUser(){
        return userRepository.findAll();
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        userRepository.save(user);
        return user;
    }
}
