package com.openclassroom.projet12.controller;



import com.amazonaws.services.xray.model.Http;
import com.openclassroom.projet12.dto.UserDTO;
import com.openclassroom.projet12.mapper.UserMapper;
import com.openclassroom.projet12.model.ShoppingCart;
import com.openclassroom.projet12.model.User;
import com.openclassroom.projet12.service.AuthenticationService;
import com.openclassroom.projet12.service.MailService;
import com.openclassroom.projet12.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final MailService mailService;
    private final AuthenticationService authenticationService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/myprofil")
    public ResponseEntity<UserDTO> getMyProfil() {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        if(currentUsername == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        UserDTO userDTO = userService.findByEmail(currentUsername);
        if(userDTO == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'utilisateur n'existe pas");
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }


    @GetMapping("/forgot-password")
    public ResponseEntity<UserDTO> getUserByToken(@RequestParam("token") String token) throws Exception {
        if (token == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le token est invalide");
        UserDTO user = userService.findUserByToken(token);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody UserDTO userDTO) {
        User userToCreate = userService.addUser(userDTO);
        return new ResponseEntity<>(userToCreate,HttpStatus.CREATED);

    }

    @PostMapping("/forgetPassword")
    public ResponseEntity<String> forgetPassword(@RequestParam("email") String email) {
        String token = userService.forgotPassword(email);
        String link = "http://localhost:4200/forgot-password?token=" +token;
        mailService.sendEmail("deneux.j@gmail.com", link);
        return new ResponseEntity<>(link, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO) {
        User user = userService.updateUser(userDTO);
        return ResponseEntity.ok(UserMapper.toUserDTO(user));
    }

    @PutMapping("/reset-password/{id}")
    public ResponseEntity updatePassword(@PathVariable("id") Long id,
                                         @RequestBody String password) {
        userService.updatePassword(id,password);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.deleteUser(userService.deleteUser(id)), HttpStatus.OK);
    }

    @DeleteMapping("/cleanShoppingCart")
    public ResponseEntity cleanShoppingCart() {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        userService.cleanShoppingCart(currentUsername);
        return new ResponseEntity(HttpStatus.OK);
    }
}
