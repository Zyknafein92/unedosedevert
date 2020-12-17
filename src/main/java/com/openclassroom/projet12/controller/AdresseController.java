package com.openclassroom.projet12.controller;

import com.openclassroom.projet12.dto.AdresseDTO;
import com.openclassroom.projet12.model.Adresse;
import com.openclassroom.projet12.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user/address")
public class AdresseController {

    @Autowired
    AdresseService adresseService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Adresse>> getAdresse(@PathVariable("id") Long id) {
        Optional<Adresse> adresse = adresseService.getAdresse(id);
        if(!adresse.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cette adresse n'existe pas");
        return new ResponseEntity<>(adresse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Adresse> addAdresse(@Valid @RequestBody AdresseDTO adresseDTO) {
        Adresse adresseToCreate = adresseService.addAdresse(adresseDTO);
        return new ResponseEntity<>(adresseToCreate,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Adresse> updateAdresse(@Valid @RequestBody AdresseDTO adresseDTO) {
        Adresse adresse = adresseService.updateAdresse(adresseDTO);
        return new ResponseEntity<>(adresse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteAdresse(@PathVariable("id") Long id) {
        return new ResponseEntity<>(adresseService.deleteAdresse(id), HttpStatus.OK);
    }
}
