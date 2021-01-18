package com.openclassroom.projet12.controller;

import com.openclassroom.projet12.dto.TagDTO;
import com.openclassroom.projet12.model.Tag;
import com.openclassroom.projet12.service.TagService;
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
@RequestMapping("/api/produits/tag")
@AllArgsConstructor
public class TagController {

    private final TagService tagService;

    public ResponseEntity<List<Tag>> getTags() {
        List<Tag> tags = tagService.getTags();
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Tag>> getTag(@PathVariable("id") Long id) {
        Optional<Tag> tag = tagService.getTag(id);
        if(!tag.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le tag n'existe pas");
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tag> addTag(@Valid @RequestBody TagDTO tagDTO) {
        Tag tagToCreate = tagService.addTag(tagDTO);
        return new ResponseEntity<>(tagToCreate,HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Tag> updateTag(@Valid @RequestBody TagDTO tagDTO) {
        Tag tag = tagService.updateTag(tagDTO);
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteTag(@PathVariable("id") Long id) {
        Optional<Tag> tag = tagService.getTag(id);
        if(!tag.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le tag n'existe pas");
        return new ResponseEntity<>(tagService.deleteTag(tag.get().getId()), HttpStatus.OK);
    }
}
