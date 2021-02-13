package com.openclassroom.projet12.controller;

import com.openclassroom.projet12.dto.CategorieDTO;
import com.openclassroom.projet12.dto.VariantDTO;
import com.openclassroom.projet12.model.Variant;
import com.openclassroom.projet12.service.VariantService;
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
@RequestMapping("/api/produits/variants")
@AllArgsConstructor
public class VariantController {

    private final VariantService variantService;

    public ResponseEntity<List<Variant>> getVariants() {
        List<Variant> variants = variantService.getVariants();
        return new ResponseEntity<>(variants, HttpStatus.OK);
    }

    @GetMapping("/produit/{produitID}")
    public ResponseEntity<List<Variant>> getVariantsByProductId(@PathVariable("produitID") Long id) {
        List<Variant> variantList = variantService.getVariantsByProductId(id);
        if(variantList.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun variant n'est disponible pour ce produit");
        return new ResponseEntity<>(variantList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Variant>> getVariant(@PathVariable("id") Long id) {
        Optional<Variant> variant = variantService.getVariant(id);
        if(!variant.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le variant n'existe pas");
        return new ResponseEntity<>(variant, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Variant> addVariant(@Valid @RequestBody VariantDTO variantDTO) {
        Variant variantToCreate = variantService.addVariant(variantDTO);
        return new ResponseEntity<>(variantToCreate,HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Variant> updateVariant(@Valid @RequestBody VariantDTO variantDTO) {
        Variant variant = variantService.updateVariant(variantDTO);
        return new ResponseEntity<>(variant, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteVariant(@PathVariable("id") Long id) {
        Optional<Variant> variant = variantService.getVariant(id);
        if(!variant.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le variant n'existe pas");
        return new ResponseEntity<>(variantService.deleteVariant(variant.get().getId()), HttpStatus.OK);
    }
}
