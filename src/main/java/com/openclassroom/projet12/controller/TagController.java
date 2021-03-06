package com.openclassroom.projet12.controller;

import com.openclassroom.projet12.dto.CategorieDTO;
import com.openclassroom.projet12.dto.TagDTO;
import com.openclassroom.projet12.model.Tag;
import com.openclassroom.projet12.service.TagService;
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
@RequestMapping("/api/produits/tag")
@AllArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping
    public ResponseEntity<List<Tag>> getTags() {
        List<Tag> tags = tagService.getTags();
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }

    @GetMapping("/tags")
    public Page<TagDTO> getTagsPage(Pageable pageable) {
        return tagService.getTagPage(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> getTag(@PathVariable("id") Long id) {
        return new ResponseEntity<>(tagService.getTag(id), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Tag> addTag(@Valid @RequestBody TagDTO tagDTO) {
        return new ResponseEntity<>(tagService.addTag(tagDTO),HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Tag> updateTag(@Valid @RequestBody TagDTO tagDTO) {
        Tag tag = tagService.updateTag(tagDTO);
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Long> deleteTag(@PathVariable("id") Long id) {
        return new ResponseEntity<>(tagService.deleteTag(id), HttpStatus.OK);
    }
}
