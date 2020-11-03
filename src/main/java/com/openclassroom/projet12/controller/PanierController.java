package com.openclassroom.projet12.controller;


import com.openclassroom.projet12.dto.PanierDTO;
import com.openclassroom.projet12.dto.PanierLigneDTO;
import com.openclassroom.projet12.model.Panier;
import com.openclassroom.projet12.model.PanierLigne;
import com.openclassroom.projet12.service.PanierService;
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
@RequestMapping("/api/utilisateur/panier")
public class PanierController {

    @Autowired
    PanierService panierService;

    //todo: récupérer directement par l'utilisateur et pas de recherche par id.
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Panier>> getPanier(@PathVariable("id") Long id) {
        Optional<Panier> panier = panierService.getPanier(id);
        if(!panier.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le panier n'existe pas");
        return new ResponseEntity<>(panier, HttpStatus.OK);

        /** Algro simple
         * Trouver la personne connecté (client connecté) ??? Il faut implémenter userservice detail (spring sécurité) // userservice.getAuthenticatedUsername() => get client by username
         * à partir de personne trouvé: client.getPanier()
         * retouner le panier.
         * */
    }

    @PostMapping
    public ResponseEntity<Panier> addPanier(@Valid @RequestBody PanierDTO panierDTO) {
        Panier panierToCreate = panierService.addPanier(panierDTO);
        return new ResponseEntity<>(panierToCreate,HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Panier> updatePanier(@Valid @RequestBody PanierDTO panierDTO) {
        Panier panier = panierService.updatePanier(panierDTO);
        return new ResponseEntity<>(panier, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deletePanier(@PathVariable("id") Long id) {
        Optional<Panier> panier = panierService.getPanier(id);
        if(!panier.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le panier n'existe pas");
        return new ResponseEntity<>(panierService.deletePanier(panier.get().getId()), HttpStatus.OK);
    }

    /*
     *             PanierLigne
     *
     */

//    @GetMapping
//    public ResponseEntity<List<PanierLigne>> getPanierLignes() {
//        List<PanierLigne> panierList = panierService.getPanierLignes();
//        return new ResponseEntity<>(panierList, HttpStatus.OK);
//    }
//
//    @GetMapping("/{idPanier}")
//    public ResponseEntity<Optional<PanierLigne>> getPanierLigne(@PathVariable("idPanier") Long idPanier) {
//        Optional<PanierLigne> panierLigne = panierService.getPanierLigne(idPanier);
//        if(!panierLigne.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La ligne du panier n'existe pas");
//        return new ResponseEntity<>(panierLigne, HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<PanierLigne> addPanierLigne(@Valid @RequestBody PanierLigneDTO panierLigneDTO) {
//        PanierLigne panierLigneToCreate = panierService.addPanierLigne(panierLigneDTO);
//        return new ResponseEntity<>(panierLigneToCreate,HttpStatus.CREATED);
//
//    }
//
//    @PutMapping
//    public ResponseEntity<PanierLigne> updatePanierLigne(@Valid @RequestBody PanierLigneDTO panierLigneDTO) {
//        PanierLigne panierLigne = panierService.updatePanierLigne(panierLigneDTO);
//        return new ResponseEntity<>(panierLigne, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{idPanier}")
//    public ResponseEntity<Long> deletePanierLigne(@PathVariable("idPanier") Long idPanier) {
//        Optional<PanierLigne> panierLigne = panierService.getPanierLigne(idPanier);
//        if(!panierLigne.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La ligne du panier n'existe pas");
//        return new ResponseEntity<>(panierService.deletePanierLigne(panierLigne.get().getId()), HttpStatus.OK);
//    }
}
