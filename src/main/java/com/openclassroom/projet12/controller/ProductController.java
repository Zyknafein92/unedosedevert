package com.openclassroom.projet12.controller;



import com.openclassroom.projet12.dto.ProductDTO;
import com.openclassroom.projet12.dto.SearchCriteria;
import com.openclassroom.projet12.model.Product;
import com.openclassroom.projet12.service.ProductService;
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
@RequestMapping("/api/produits")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProduits() {
        List<ProductDTO> produits = productService.getProduits();
        return new ResponseEntity<>(produits, HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<ProductDTO>> findProduitsByCriteria(@RequestBody(required = false) SearchCriteria searchCriteria) {
        return new ResponseEntity<>(productService.findProduitsBySpecification(searchCriteria), HttpStatus.OK);
    }


    @GetMapping("/xxx")
    public Page<ProductDTO> getProduitPage(Pageable pageable) {
        return productService.getProduitPage(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduit(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.getProduitDTO(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Product> addProduit(@Valid @RequestBody ProductDTO productDTO) {
        Product productToCreate = productService.addProduit(productDTO);
        return new ResponseEntity<>(productToCreate,HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Product> updateProduit(@Valid @RequestBody ProductDTO productDTO) {
        Product product = productService.updateProduit(productDTO);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteProduit(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.deleteProduit(id), HttpStatus.OK);
    }
}
