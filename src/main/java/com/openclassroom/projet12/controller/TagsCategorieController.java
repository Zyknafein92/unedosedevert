package com.openclassroom.projet12.controller;

import com.openclassroom.projet12.dto.TagsCategorieDTO;
import com.openclassroom.projet12.model.TagsCategorie;
import com.openclassroom.projet12.service.TagsCategorieService;
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
@RequestMapping("/api/produits/tagsCategories")
@AllArgsConstructor
public class TagsCategorieController {

    private final TagsCategorieService tagsCategorieService;

    public ResponseEntity<List<TagsCategorie>> getTagsCategories() {
        List<TagsCategorie> tagsCategories = tagsCategorieService.getTagsCategories();
        return new ResponseEntity<>(tagsCategories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TagsCategorie>> getTagsCategorie(@PathVariable("id") Long id) {
        Optional<TagsCategorie> tagsCategorie = tagsCategorieService.getTagsCategorie(id);
        if(!tagsCategorie.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La catégorie de tag n'existe pas");
        return new ResponseEntity<>(tagsCategorie, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TagsCategorie> addTagsCategorie(@Valid @RequestBody TagsCategorieDTO tagsCategorieDTO) {
        TagsCategorie tagsCategorieToCreate = tagsCategorieService.addTagsCategorie(tagsCategorieDTO);
        return new ResponseEntity<>(tagsCategorieToCreate,HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<TagsCategorie> updateTagsCategorie(@Valid @RequestBody TagsCategorieDTO tagsCategorieDTO) {
        TagsCategorie tagsCategorie = tagsCategorieService.updateTagsCategorie(tagsCategorieDTO);
        return new ResponseEntity<>(tagsCategorie, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteTagsCategorie(@PathVariable("id") Long id) {
        Optional<TagsCategorie> tagsCategorie = tagsCategorieService.getTagsCategorie(id);
        if(!tagsCategorie.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La catégorie de tag n'existe pas");
        return new ResponseEntity<>(tagsCategorieService.deleteTagsCategorie(tagsCategorie.get().getId()), HttpStatus.OK);
    }
}
