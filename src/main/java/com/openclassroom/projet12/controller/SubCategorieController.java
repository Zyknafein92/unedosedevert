package com.openclassroom.projet12.controller;

import com.openclassroom.projet12.dto.SubCategorieDTO;
import com.openclassroom.projet12.model.SubCategorie;
import com.openclassroom.projet12.service.SubCategorieService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/produits/sousCategorie") // todo: /api/categorie/{categorieID}/subCategorie
@AllArgsConstructor
public class SubCategorieController {

    private final SubCategorieService subCategorieService;

    @GetMapping
    public ResponseEntity<List<SubCategorieDTO>> getSubCategories() {
        List<SubCategorieDTO> subCategories = subCategorieService.getSubCategories();
        return new ResponseEntity<>(subCategories, HttpStatus.OK);
    }

    @GetMapping("/subCategories")
    public Page<SubCategorieDTO> getSubCategoriesPage(Pageable pageable) {
        return subCategorieService.getSubCategoriesPage(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubCategorie> getSubCategorie(@PathVariable("id") Long id) {
        return new ResponseEntity<>(subCategorieService.getSubCategorie(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SubCategorie> addSubCategorie(@Valid @RequestBody SubCategorieDTO subCategorieDTO) {
        SubCategorie subCategorieToCreate = subCategorieService.addSubCategorie(subCategorieDTO);
        return new ResponseEntity<>(subCategorieToCreate,HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<SubCategorie> updateSousCategorie(@Valid @RequestBody SubCategorieDTO subCategorieDTO) {
        SubCategorie subCategorie = subCategorieService.updateSubCategorie(subCategorieDTO);
        return new ResponseEntity<>(subCategorie, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteSousCategorie(@PathVariable("id") Long id) {
        return new ResponseEntity<>(subCategorieService.deleteSubCategorie(id), HttpStatus.OK);
    }
}
