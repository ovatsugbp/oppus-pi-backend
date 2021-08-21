package br.com.oppus.api.controller;

import br.com.oppus.api.model.entities.User;
import br.com.oppus.api.model.repositories.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).body(savedUser);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user){
        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()){
            return  ResponseEntity.unprocessableEntity().build();
        }

        user.setId(userOptional.get().getId());
        userRepository.save(user);

        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/me/{id}")
    public ResponseEntity<User> deleteUserData(@PathVariable Integer id){
        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        userRepository.delete(userOptional.get());

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/me/{id}")
    public ResponseEntity<User> getMyUserData(@PathVariable Integer id){
        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(userOptional.get());
    }
}
