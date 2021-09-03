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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/produits/{produitId}/variants")
@AllArgsConstructor
public class VariantController {

    private final VariantService variantService;

    public ResponseEntity<List<Variant>> getVariants() {
        List<Variant> variants = variantService.getVariants();
        return new ResponseEntity<>(variants, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<VariantDTO>> getVariantsByProductId(@PathVariable("produitId") Long id) {
        return new ResponseEntity<>(variantService.getVariantsByProductId(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VariantDTO> getVariant(@PathVariable("id") Long id) {
        return new ResponseEntity<>(variantService.getVariantDTO(id), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<VariantDTO> addVariant(@PathVariable("produitId") Long id, @Valid @RequestBody VariantDTO variantDTO) {
        VariantDTO variantToCreate = variantService.addVariant(id,variantDTO);
        return new ResponseEntity<>(variantToCreate,HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<VariantDTO> updateVariant(@PathVariable("produitId") Long id, @Valid @RequestBody VariantDTO variantDTO) {
        VariantDTO variantToSend = variantService.updateVariant(variantDTO);
        return new ResponseEntity<>(variantToSend, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Long> deleteVariant(@PathVariable("id") Long id) {
        return new ResponseEntity<>(variantService.deleteVariant(id), HttpStatus.OK);
    }
}
