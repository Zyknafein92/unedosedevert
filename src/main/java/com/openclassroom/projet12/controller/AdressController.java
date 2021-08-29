package com.openclassroom.projet12.controller;

import com.openclassroom.projet12.dto.AdressDTO;
import com.openclassroom.projet12.model.Adress;
import com.openclassroom.projet12.service.AdressService;
import com.openclassroom.projet12.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user/address")
@AllArgsConstructor
public class AdressController {

    private final AdressService adressService;

    private final AuthenticationService authenticationService;

    @GetMapping("/{id}")
    public ResponseEntity<Adress> getAdresse(@PathVariable("id") Long id) {
        return new ResponseEntity<>(adressService.getAddress(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Adress> addAdresse(@Valid @RequestBody AdressDTO adressDTO) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        Adress adressToCreate = adressService.addAddress(adressDTO, currentUsername);
        return new ResponseEntity<>(adressToCreate,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Adress> updateAdresse(@Valid @RequestBody AdressDTO adressDTO) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        Adress adress = adressService.updateAddress(adressDTO,currentUsername);
        return new ResponseEntity<>(adress, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteAdresse(@PathVariable("id") Long id) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        return new ResponseEntity<>(adressService.deleteAddress(id, currentUsername), HttpStatus.OK);
    }
}
