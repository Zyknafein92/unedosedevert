package com.openclassroom.projet12.controller;

import com.openclassroom.projet12.dto.LabelDTO;
import com.openclassroom.projet12.model.Label;
import com.openclassroom.projet12.service.LabelService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/produits/label")
@AllArgsConstructor
public class LabelController {

    private final LabelService labelService;

    @GetMapping
    public ResponseEntity<List<Label>> getLabelCategories() {
        return new ResponseEntity<>(labelService.getLabels(), HttpStatus.OK);
    }

    @GetMapping("/labels")
    public Page<LabelDTO> getLabelCategoriePage(Pageable pageable) {
        return labelService.getLabelPage(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Label> getLabelCategorie(@PathVariable("id") Long id) {
        return new ResponseEntity<>(labelService.getLabel(id), HttpStatus.OK);
    }


    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Label> addLabel(@Valid @RequestBody LabelDTO labelDTO) {
        Label labelToCreate = labelService.addLabel(labelDTO);
        return new ResponseEntity<>(labelToCreate,HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Label> updateLabel(@Valid @RequestBody LabelDTO labelDTO) {
        Label label = labelService.updateLabel(labelDTO);
        return new ResponseEntity<>(label, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Long> deleteLabel(@PathVariable("id") Long id) {
        return new ResponseEntity<>(labelService.deleteLabel(id), HttpStatus.OK);
    }
}
