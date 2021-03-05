package com.openclassroom.projet12.controller;

import com.openclassroom.projet12.dto.SousCategorieDTO;
import com.openclassroom.projet12.model.SousCategorie;
import com.openclassroom.projet12.service.SousCategorieService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/produits/sousCategorie")
@AllArgsConstructor
public class SousCategorieController {

    private final SousCategorieService sousCategorieService;

    @GetMapping
    public ResponseEntity<List<SousCategorie>> getSousCategories() {
        List<SousCategorie> sousCategories = sousCategorieService.getSousCategories();
        return new ResponseEntity<>(sousCategories, HttpStatus.OK);
    }

    @GetMapping("/xxx")
    public Page<SousCategorieDTO> getSousCategoriePage(Pageable pageable) {
        return sousCategorieService.getSousContegoriePage(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SousCategorie> getSousCategorie(@PathVariable("id") Long id) {
        return new ResponseEntity<>(sousCategorieService.getSousCategorie(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SousCategorie> addSousCategorie(@Valid @RequestBody SousCategorieDTO sousCategorieDTO) {
        SousCategorie sousCategorieToCreate = sousCategorieService.addSousCategorie(sousCategorieDTO);
        return new ResponseEntity<>(sousCategorieToCreate,HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<SousCategorie> updateSousCategorie(@Valid @RequestBody SousCategorieDTO sousCategorieDTO) {
        SousCategorie sousCategorie = sousCategorieService.updateSousCategorie(sousCategorieDTO);
        return new ResponseEntity<>(sousCategorie, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteSousCategorie(@PathVariable("id") Long id) {
        return new ResponseEntity<>(sousCategorieService.deleteSousCategorie(id), HttpStatus.OK);
    }
}
