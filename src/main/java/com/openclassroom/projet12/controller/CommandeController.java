package com.openclassroom.projet12.controller;


import com.openclassroom.projet12.dto.CommandeDTO;
import com.openclassroom.projet12.model.Commande;
import com.openclassroom.projet12.service.AuthenticationService;
import com.openclassroom.projet12.service.CommandeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/order")
@AllArgsConstructor
public class CommandeController {

    private final CommandeService commandeService;

    private final AuthenticationService authenticationService;

    @GetMapping
    // TODO : only admin has right to view this
    public ResponseEntity<List<Commande>> getCommandes() {
        List<Commande> commandes = commandeService.getCommandes();
        return new ResponseEntity<>(commandes, HttpStatus.OK);
    }

//    /** Get all orders for a user */
//    @GetMapping("/users/{username}")
//    public ResponseEntity<List<Commande>> getOrdersForCurrentUser(@PathVariable("username") String username) {
//        String currentUsername = authenticationService.getCurrentLoggedInUsername();
//        if(currentUsername == null || !username.equals(currentUsername)) {
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }
//
//        List<Commande> commandes = commandeService.getCommandesForCurrentUser(username);
//        return new ResponseEntity<>(commandes, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommande(@PathVariable("id") Long id) {
        return new ResponseEntity<>(commandeService.getCommande(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Commande> addCommande(@Valid @RequestBody CommandeDTO commandeDTO) {
        Commande commandeToCreate = commandeService.addCommande(commandeDTO);
        return new ResponseEntity<>(commandeToCreate,HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Commande> updateCommande(@Valid @RequestBody CommandeDTO commandeDTO) {
        Commande commande = commandeService.updateCommande(commandeDTO);
        return new ResponseEntity<>(commande, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteCommande(@PathVariable("id") Long id) {
        return new ResponseEntity<>(commandeService.deleteCommande(id), HttpStatus.OK);
    }
}
