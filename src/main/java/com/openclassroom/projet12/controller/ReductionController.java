package com.openclassroom.projet12.controller;

import com.openclassroom.projet12.dto.ReductionDTO;
import com.openclassroom.projet12.dto.VariantDTO;
import com.openclassroom.projet12.model.Reduction;
import com.openclassroom.projet12.model.Variant;
import com.openclassroom.projet12.service.ReductionService;
import com.openclassroom.projet12.service.VariantService;
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
@RequestMapping("/api/produits/{produitID}/reduction")
@AllArgsConstructor
public class ReductionController {

    private final ReductionService reductionService;

    @GetMapping()
    public ResponseEntity<ReductionDTO> getReductionByProductId(@PathVariable("produitID") Long id) {
        return new ResponseEntity<>(reductionService.findReductionByProduitId(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reduction> getReduction(@PathVariable("id") Long id) {
        return new ResponseEntity<>(reductionService.getReduction(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Reduction> addReduction(@Valid @RequestBody ReductionDTO reductionDTO) {
        Reduction reductionToCreate = reductionService.addReduction(reductionDTO);
        return new ResponseEntity<>(reductionToCreate,HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Reduction> updateReduction(@Valid @RequestBody ReductionDTO reductionDTO) {
        Reduction reduction = reductionService.updateReduction(reductionDTO);
        return new ResponseEntity<>(reduction, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReduction(@PathVariable("id") Long id) {
        reductionService.deleteReduction(id);
        return new ResponseEntity<Void> (HttpStatus.OK);
    }
}
