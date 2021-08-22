package com.openclassroom.projet12.controller;

import com.openclassroom.projet12.dto.TypeDTO;
import com.openclassroom.projet12.model.Type;
import com.openclassroom.projet12.service.TypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/produits/type")
@AllArgsConstructor
public class TypeController {

    private final TypeService typeService;

    @GetMapping
    public ResponseEntity<List<Type>> getTypes() {
        List<Type> types = typeService.getTypes();
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Type> getType(@PathVariable("id") Long id) {
        return new ResponseEntity<>(typeService.getType(id), HttpStatus.OK);
    }

    @GetMapping("/types")
    public Page<TypeDTO> getTypePage(Pageable pageable) {
        return typeService.getTypePage(pageable);
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
        return new ResponseEntity<>(typeService.deleteType(id), HttpStatus.OK);
    }
}
