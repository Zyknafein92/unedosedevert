package com.openclassroom.projet12.controller;

import com.openclassroom.projet12.dto.TypeDTO;
import com.openclassroom.projet12.model.Type;
import com.openclassroom.projet12.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/produits/type")
public class TypeController {

    @Autowired
    TypeService typeService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Type>> getType(@PathVariable("id") Long id) {
        Optional<Type> type = typeService.getType(id);
        if (!type.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ce type n'existe pas");
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Type> addType(@Valid @RequestBody TypeDTO typeDTO) {
        Type typeToCreate = typeService.addType(typeDTO);
        return new ResponseEntity<>(typeToCreate, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Type> updateType(@Valid @RequestBody TypeDTO typeDTO) {
        Type type = typeService.updateType(typeDTO);
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteType(@PathVariable("id") Long id) {
        Optional<Type> type = typeService.getType(id);
        if (!type.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ce type n'existe pas");
        return new ResponseEntity<>(typeService.deleteType(type.get().getId()), HttpStatus.OK);
    }
}
