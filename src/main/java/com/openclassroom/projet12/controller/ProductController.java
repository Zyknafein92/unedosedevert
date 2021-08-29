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
    public ResponseEntity<List<ProductDTO>> getProducts() {
        List<ProductDTO> produits = productService.getProducts();
        return new ResponseEntity<>(produits, HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<ProductDTO>> findProductsByCriteria(@RequestBody(required = false) SearchCriteria searchCriteria) {
        return new ResponseEntity<>(productService.findProductsBySpecification(searchCriteria), HttpStatus.OK);
    }

    @GetMapping("/products")
    public Page<ProductDTO> getProductPage(Pageable pageable) {
        return productService.getProductPage(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.getProductDTO(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody ProductDTO productDTO) {
        Product productToCreate = productService.addProduct(productDTO);
        return new ResponseEntity<>(productToCreate,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductDTO> updateProduct(@Valid @RequestBody ProductDTO productDTO) {
        ProductDTO productToPush = productService.updateProduct(productDTO);
        return new ResponseEntity<>(productToPush, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteProduct(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }
}
