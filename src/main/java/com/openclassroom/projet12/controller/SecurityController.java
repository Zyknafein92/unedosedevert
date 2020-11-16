package com.openclassroom.projet12.controller;

import com.openclassroom.projet12.config.jwt.JwtProvider;
import com.openclassroom.projet12.config.jwt.JwtResponse;

import com.openclassroom.projet12.dto.UserCredentialsDTO;
import com.openclassroom.projet12.model.User;
import com.openclassroom.projet12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/login")
public class SecurityController {

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public JwtResponse login (@Valid @RequestBody UserCredentialsDTO user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateJwtToken(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        } catch (Exception e) {
            throw new ResponseStatusException (UNAUTHORIZED, " Identification incorrecte");
        }
    }
}
