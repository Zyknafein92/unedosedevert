package com.openclassroom.projet12.controller;


import com.openclassroom.projet12.dto.ProduitDTO;
import com.openclassroom.projet12.model.Categorie;
import com.openclassroom.projet12.model.Produit;
import com.openclassroom.projet12.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping
    public ResponseEntity<List<Produit>> getProduits() {
        List<Produit> produits = produitService.getProduits();
        return new ResponseEntity<>(produits, HttpStatus.OK);
    }

    // http://localhost:8080/api/produits?size=5&page=30&sort=name
//    @GetMapping
//    public Page<Produit> getProduits(Pageable pageable) {
//        return produitService.findProduits(pageable);
//    }

    //todo : corriger les optionales comme ci-dessous
    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduit(@PathVariable("id") Long id) {
        Optional<Produit> produit = produitService.getProduit(id);
        if(!produit.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le produit n'existe pas");
        return new ResponseEntity<>(produit.get(), HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Categorie>> getCategories() {
       //List<String> categories = Stream.of(Categorie.values()).map(Categorie::getDescription).collect(Collectors.toList());
       return new ResponseEntity<>(Arrays.asList(Categorie.values()), HttpStatus.OK);
        //return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Produit> addProduit(@Valid @RequestBody ProduitDTO produitDTO) {
        Produit produitToCreate = produitService.addProduit(produitDTO);
        return new ResponseEntity<>(produitToCreate,HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Produit> updateProduit(@Valid @RequestBody ProduitDTO produitDTO) {
        Produit produit = produitService.updateProduit(produitDTO);
        return new ResponseEntity<>(produit, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteProduit(@PathVariable("id") Long id) {
        Optional<Produit> produit = produitService.getProduit(id);
        if(!produit.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le produit n'existe pas");
        return new ResponseEntity<>(produitService.deleteProduit(produit.get().getId()), HttpStatus.OK);
    }
}
