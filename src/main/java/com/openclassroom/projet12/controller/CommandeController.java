package com.openclassroom.projet12.controller;


import com.openclassroom.projet12.dto.CommandeDTO;
import com.openclassroom.projet12.model.Commande;
import com.openclassroom.projet12.service.CommandeService;
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
@RequestMapping("/api/order")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @GetMapping
    public ResponseEntity<List<Commande>> getCommandes() {
        List<Commande> commandes = commandeService.getCommandes();
        return new ResponseEntity<>(commandes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Commande>> getCommande(@PathVariable("id") Long id) {
        Optional<Commande> commande = commandeService.getCommande(id);
        if(!commande.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le commande n'existe pas");
        return new ResponseEntity<>(commande, HttpStatus.OK);
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
        Optional<Commande> commande = commandeService.getCommande(id);
        if(!commande.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le commande n'existe pas");
        return new ResponseEntity<>(commandeService.deleteCommande(commande.get().getId()), HttpStatus.OK);
    }
}
