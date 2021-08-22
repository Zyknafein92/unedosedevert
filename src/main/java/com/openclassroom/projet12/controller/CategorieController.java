package com.openclassroom.projet12.controller;

import com.openclassroom.projet12.dto.CategorieDTO;
import com.openclassroom.projet12.model.Categorie;

import com.openclassroom.projet12.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/produits/categories")
public class CategorieController {

    @Autowired
    CategorieService categorieService;

    @GetMapping
    public ResponseEntity<List<CategorieDTO>> getCategories() {
        List<CategorieDTO> categories = categorieService.getCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/categories")
    public Page<CategorieDTO> getCategoriePage(Pageable pageable) {
        return categorieService.getCategoriePage(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getCategorie(@PathVariable("id") Long id) {
        return new ResponseEntity<>(categorieService.getCategorie(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Categorie> addCategorie(@Valid @RequestBody CategorieDTO categorieDTO) {
        Categorie categorieToCreate = categorieService.addCategorie(categorieDTO);
        return new ResponseEntity<>(categorieToCreate, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Categorie> updateCategorie(@Valid @RequestBody CategorieDTO categorieDTO) {
        Categorie categorie = categorieService.updateCategorie(categorieDTO);
        return new ResponseEntity<>(categorie, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteCategorie(@PathVariable("id") Long id) {
        return new ResponseEntity<>(categorieService.deleteCategorie(id), HttpStatus.OK);
    }
}
