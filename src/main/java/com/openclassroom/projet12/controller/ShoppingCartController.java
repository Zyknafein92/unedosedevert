package com.openclassroom.projet12.controller;


import com.openclassroom.projet12.dto.OrderDTO;
import com.openclassroom.projet12.dto.ShoppingCartDTO;
import com.openclassroom.projet12.dto.ShoppingCartLineDTO;
import com.openclassroom.projet12.model.Order;
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
    public ResponseEntity<ShoppingCartDTO> getShoppingCart() {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        return new ResponseEntity<>(shoppingCartService.getShoppingCart(currentUsername), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ShoppingCart> addToShoppingCart(@Valid @RequestBody List<ShoppingCartLineDTO> shoppingCartLineDTOList) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        ShoppingCart shoppingCartToCreate = shoppingCartService.addToShoppingCart(shoppingCartLineDTOList, currentUsername);
        return new ResponseEntity<>(shoppingCartToCreate,HttpStatus.CREATED);
    }

    @PostMapping("/renewOrder")
    public ResponseEntity<ShoppingCart> renewOrder(@Valid @RequestBody OrderDTO orderDTO) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        ShoppingCart shoppingCartToRenew = shoppingCartService.renewOrder(orderDTO, currentUsername);
        return new ResponseEntity<>(shoppingCartToRenew,HttpStatus.CREATED);
    }



    /*
     *             ShoppingCartLine
     *
     */

    @GetMapping("/{idPanier}")
    public ResponseEntity<ShoppingCartLine> getShoppingCartLine(@PathVariable("idPanier") Long idPanier) {
        ShoppingCartLine shoppingCartLine = shoppingCartService.getShoppingCartLine(idPanier);
        return new ResponseEntity<>(shoppingCartLine, HttpStatus.OK);
    }

    @PostMapping("/shoppingCartLine")
    public ResponseEntity<ShoppingCartLine> addShoppingCartLine(@Valid @RequestBody ShoppingCartLineDTO shoppingCartLineDTO) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        ShoppingCartLine shoppingCartLineToCreate = shoppingCartService.addShoppingCartLine(shoppingCartLineDTO, currentUsername);
        return new ResponseEntity<>(shoppingCartLineToCreate,HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<ShoppingCartLine> updateShoppingCartLine(@Valid @RequestBody ShoppingCartLineDTO shoppingCartLineDTO) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        ShoppingCartLine shoppingCartLine = shoppingCartService.updateShoppingCartLine(shoppingCartLineDTO, currentUsername);
        return new ResponseEntity<>(shoppingCartLine, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShoppingCartLine(@PathVariable("id") Long id) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        return new ResponseEntity (shoppingCartService.deleteShoppingCartLine(currentUsername, id), HttpStatus.OK);
    }

}
