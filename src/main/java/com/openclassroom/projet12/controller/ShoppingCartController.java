package com.openclassroom.projet12.controller;


import com.openclassroom.projet12.dto.ShoppingCartDTO;
import com.openclassroom.projet12.dto.ShoppingCartLineDTO;
import com.openclassroom.projet12.model.ShoppingCart;
import com.openclassroom.projet12.model.ShoppingCartLine;
import com.openclassroom.projet12.service.AuthenticationService;
import com.openclassroom.projet12.service.ShoppingCartService;
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
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    private final AuthenticationService authenticationService;

    @GetMapping()
    public ResponseEntity<ShoppingCartDTO> getPanier() {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        return new ResponseEntity<>(shoppingCartService.getPanier(currentUsername), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ShoppingCart> addToPanier(@Valid @RequestBody List<ShoppingCartLineDTO> shoppingCartLineDTOList) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        ShoppingCart shoppingCartToCreate = shoppingCartService.addToPanier(shoppingCartLineDTOList, currentUsername);
        return new ResponseEntity<>(shoppingCartToCreate,HttpStatus.CREATED);
    }


    /*
     *             ShoppingCartLine
     *
     */

    @GetMapping("/{idPanier}")
    public ResponseEntity<ShoppingCartLine> getPanierLigne(@PathVariable("idPanier") Long idPanier) {
        ShoppingCartLine shoppingCartLine = shoppingCartService.getPanierLigne(idPanier);
        return new ResponseEntity<>(shoppingCartLine, HttpStatus.OK);
    }

    @PostMapping("/panierLigne")
    public ResponseEntity<ShoppingCartLine> addPanierLigne(@Valid @RequestBody ShoppingCartLineDTO shoppingCartLineDTO) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        ShoppingCartLine shoppingCartLineToCreate = shoppingCartService.addPanierLigne(shoppingCartLineDTO, currentUsername);
        return new ResponseEntity<>(shoppingCartLineToCreate,HttpStatus.CREATED);

    }

    @PutMapping("/panierLigne")
    public ResponseEntity<ShoppingCartLine> updatePanierLigne(@Valid @RequestBody ShoppingCartLineDTO shoppingCartLineDTO) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        ShoppingCartLine shoppingCartLine = shoppingCartService.updatePanierLigne(shoppingCartLineDTO, currentUsername);
        return new ResponseEntity<>(shoppingCartLine, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePanierLigne(@PathVariable("id") Long id) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        return new ResponseEntity (shoppingCartService.deletePanierLigne(currentUsername, id), HttpStatus.OK);
    }
}
