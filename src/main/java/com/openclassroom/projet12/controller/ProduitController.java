package com.openclassroom.projet12.controller;



import com.openclassroom.projet12.dto.ProduitDTO;
import com.openclassroom.projet12.dto.SearchCriteria;
import com.openclassroom.projet12.model.Produit;
import com.openclassroom.projet12.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping
    public ResponseEntity<List<ProduitDTO>> getProduits() {
        List<ProduitDTO> produits = produitService.getProduits();
        return new ResponseEntity<>(produits, HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<ProduitDTO>> findProduitsByCriteria(@RequestBody(required = false) SearchCriteria searchCriteria) {
        return new ResponseEntity<>(produitService.findProduitsBySpecification(searchCriteria), HttpStatus.OK);
    }


    @GetMapping("/xxx")
    public Page<ProduitDTO> getProduitPage(Pageable pageable) {
        return produitService.getProduitPage(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProduitDTO> getProduit(@PathVariable("id") Long id) {
        return new ResponseEntity<>(produitService.getProduitDTO(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Produit> addProduit(@Valid @RequestBody ProduitDTO produitDTO) {
        Produit produitToCreate = produitService.addProduit(produitDTO);
        return new ResponseEntity<>(produitToCreate,HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Produit> updateProduit(@Valid @RequestBody ProduitDTO produitDTO) {
        Produit produit = produitService.updateProduit(produitDTO);
        return new ResponseEntity<>(produit, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteProduit(@PathVariable("id") Long id) {
        return new ResponseEntity<>(produitService.deleteProduit(id), HttpStatus.OK);
    }
}
