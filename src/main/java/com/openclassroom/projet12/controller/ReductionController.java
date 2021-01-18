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
@RequestMapping("/api/produits/reductions")
@AllArgsConstructor
public class ReductionController {

    private final ReductionService reductionService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Reduction>> getReduction(@PathVariable("id") Long id) {
        Optional<Reduction> reduction = reductionService.getReduction(id);
        if(!reduction.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La reduction n'existe pas");
        return new ResponseEntity<>(reduction, HttpStatus.OK);
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
    public ResponseEntity<Long> deleteReduction(@PathVariable("id") Long id) {
        Optional<Reduction> reduction = reductionService.getReduction(id);
        if(!reduction.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La reduction n'existe pas");
        return new ResponseEntity<>(reductionService.deleteReduction(reduction.get().getId()), HttpStatus.OK);
    }
}
