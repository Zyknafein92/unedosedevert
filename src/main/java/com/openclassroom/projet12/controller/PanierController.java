package com.openclassroom.projet12.controller;


import com.openclassroom.projet12.dto.PanierDTO;
import com.openclassroom.projet12.dto.PanierLigneDTO;
import com.openclassroom.projet12.model.Panier;
import com.openclassroom.projet12.model.PanierLigne;
import com.openclassroom.projet12.service.AuthenticationService;
import com.openclassroom.projet12.service.PanierService;
import lombok.AllArgsConstructor;
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

    @GetMapping()
    public ResponseEntity<PanierDTO> getPanier() {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        return new ResponseEntity<>(panierService.getPanier(currentUsername), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Panier> addToPanier(@Valid @RequestBody List<PanierLigneDTO> panierLigneDTOList) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        Panier panierToCreate = panierService.addToPanier(panierLigneDTOList, currentUsername);
        return new ResponseEntity<>(panierToCreate,HttpStatus.CREATED);
    }


    /*
     *             PanierLigne
     *
     */

    @GetMapping("/{idPanier}")
    public ResponseEntity<PanierLigne> getPanierLigne(@PathVariable("idPanier") Long idPanier) {
        PanierLigne panierLigne = panierService.getPanierLigne(idPanier);
        return new ResponseEntity<>(panierLigne, HttpStatus.OK);
    }

    @PostMapping("/panierLigne")
    public ResponseEntity<PanierLigne> addPanierLigne(@Valid @RequestBody PanierLigneDTO panierLigneDTO) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        PanierLigne panierLigneToCreate = panierService.addPanierLigne(panierLigneDTO, currentUsername);
        return new ResponseEntity<>(panierLigneToCreate,HttpStatus.CREATED);

    }

    @PutMapping("/panierLigne")
    public ResponseEntity<PanierLigne> updatePanierLigne(@Valid @RequestBody PanierLigneDTO panierLigneDTO) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        PanierLigne panierLigne = panierService.updatePanierLigne(panierLigneDTO, currentUsername);
        return new ResponseEntity<>(panierLigne, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePanierLigne(@PathVariable("id") Long id) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        return new ResponseEntity (panierService.deletePanierLigne(currentUsername, id), HttpStatus.OK);
    }
}
