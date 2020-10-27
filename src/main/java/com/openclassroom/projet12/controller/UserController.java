package com.openclassroom.projet12.controller;



import com.openclassroom.projet12.dto.UserDTO;
import com.openclassroom.projet12.model.User;
import com.openclassroom.projet12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable("id") Long id) {
        Optional<User> user = userService.getUser(id);
        if(!user.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'utilisateur n'existe pas");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody UserDTO userDTO) {
        User userToCreate = userService.addUser(userDTO);
        return new ResponseEntity<>(userToCreate,HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<User> updateUser(@Valid @RequestBody UserDTO userDTO) {
        User user = userService.updateUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable("id") Long id) {
        Optional<User> user = userService.getUser(id);
        if(!user.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'utilisateur n'existe pas");
        return new ResponseEntity<>(userService.deleteUser(user.get().getId()), HttpStatus.OK);
    }
}
