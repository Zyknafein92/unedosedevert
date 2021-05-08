package com.openclassroom.projet12.controller;

import com.openclassroom.projet12.dto.AdresseDTO;
import com.openclassroom.projet12.dto.UserDTO;
import com.openclassroom.projet12.model.Adresse;
import com.openclassroom.projet12.service.AdresseService;
import com.openclassroom.projet12.service.AuthenticationService;
import lombok.AllArgsConstructor;
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
@RequestMapping("/api/user/address")
@AllArgsConstructor
public class AdresseController {

    private final AdresseService adresseService;

    private final AuthenticationService authenticationService;

    @GetMapping("/{id}")
    public ResponseEntity<Adresse> getAdresse(@PathVariable("id") Long id) {
        return new ResponseEntity<>(adresseService.getAdresse(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Adresse> addAdresse(@Valid @RequestBody AdresseDTO adresseDTO) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        Adresse adresseToCreate = adresseService.addAdresse(adresseDTO, currentUsername);
        return new ResponseEntity<>(adresseToCreate,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Adresse> updateAdresse(@Valid @RequestBody AdresseDTO adresseDTO) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        Adresse adresse = adresseService.updateAdresse(adresseDTO,currentUsername);
        return new ResponseEntity<>(adresse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteAdresse(@PathVariable("id") Long id) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        return new ResponseEntity<>(adresseService.deleteAdresse(id, currentUsername), HttpStatus.OK);
    }
}
