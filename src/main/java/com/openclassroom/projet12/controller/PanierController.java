package com.openclassroom.projet12.controller;


import com.openclassroom.projet12.dto.PanierDTO;
import com.openclassroom.projet12.dto.PanierLigneDTO;
import com.openclassroom.projet12.model.Panier;
import com.openclassroom.projet12.model.PanierLigne;
import com.openclassroom.projet12.service.AuthenticationService;
import com.openclassroom.projet12.service.PanierService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user/panier")
@AllArgsConstructor
public class PanierController {

    private final PanierService panierService;

    private final AuthenticationService authenticationService;

    @GetMapping("/{id}")
    public ResponseEntity<PanierDTO> getPanier() {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        return new ResponseEntity<>(panierService.getPanier(currentUsername), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Panier> addPanier(@Valid @RequestBody PanierDTO panierDTO) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        Panier panierToCreate = panierService.addPanier(panierDTO, currentUsername);
        return new ResponseEntity<>(panierToCreate,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Panier> updatePanier(@Valid @RequestBody PanierDTO panierDTO) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        Panier panier = panierService.updatePanier(panierDTO, currentUsername);
        return new ResponseEntity<>(panier, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deletePanier(@PathVariable("id") Long id) {
        return new ResponseEntity<>(panierService.deletePanier(id), HttpStatus.OK);
    }

    /*
     *             PanierLigne
     *
     */

//    @GetMapping
//    public ResponseEntity<List<PanierLigne>> getPanierLignes() {
//        List<PanierLigne> panierList = panierService.getPanierLignes();
//        return new ResponseEntity<>(panierList, HttpStatus.OK);
//    }
//
//    @GetMapping("/{idPanier}")
//    public ResponseEntity<PanierLigne> getPanierLigne(@PathVariable("idPanier") Long idPanier) {
//        PanierLigne panierLigne = panierService.getPanierLigne(idPanier);
//        return new ResponseEntity<>(panierLigne, HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<PanierLigne> addPanierLigne(@Valid @RequestBody PanierLigneDTO panierLigneDTO) {
//        PanierLigne panierLigneToCreate = panierService.addPanierLigne(panierLigneDTO);
//        return new ResponseEntity<>(panierLigneToCreate,HttpStatus.CREATED);
//
//    }
//
//    @PutMapping
//    public ResponseEntity<PanierLigne> updatePanierLigne(@Valid @RequestBody PanierLigneDTO panierLigneDTO) {
//        PanierLigne panierLigne = panierService.updatePanierLigne(panierLigneDTO);
//        return new ResponseEntity<>(panierLigne, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{idPanier}/{id}")
//    public ResponseEntity<Long> deletePanierLigne(@PathVariable("idPanier") Long idPanier) {
//        PanierLigne panierLigne = panierService.getPanierLigne(idPanier);
//        return new ResponseEntity<>(panierService.deletePanierLigne(panierLigne.getId()), HttpStatus.OK);
//    }
}
