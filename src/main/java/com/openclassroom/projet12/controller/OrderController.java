package com.openclassroom.projet12.controller;


import com.openclassroom.projet12.dto.OrderDTO;
import com.openclassroom.projet12.model.Order;
import com.openclassroom.projet12.model.OrderStatus;
import com.openclassroom.projet12.service.AuthenticationService;
import com.openclassroom.projet12.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final AuthenticationService authenticationService;

    @GetMapping
    // TODO : only admin has right to view this
    public ResponseEntity<List<Order>> getCommandes() {
        List<Order> orders = orderService.getCommandes();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

//    /** Get all orders for a user */
//    @GetMapping("/users/{username}")
//    public ResponseEntity<List<Order>> getOrdersForCurrentUser(@PathVariable("username") String username) {
//        String currentUsername = authenticationService.getCurrentLoggedInUsername();
//        if(currentUsername == null || !username.equals(currentUsername)) {
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }
//
//        List<Order> orders = commandeService.getCommandesForCurrentUser(username);
//        return new ResponseEntity<>(orders, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getCommande(@PathVariable("id") Long id) {
        return new ResponseEntity<>(orderService.getCommande(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> validerCommande(@Valid @RequestBody OrderDTO orderDTO) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        Order orderToCreate = orderService.validerCommande(orderDTO, currentUsername);
        return new ResponseEntity<>(orderToCreate,HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateStatusOrder(@PathVariable("id")Long id,
                                                   @RequestBody OrderStatus orderStatus) {
        Order order = orderService.updateStatusOrder(id,orderStatus);
        return new ResponseEntity<>(order,HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Order> updateOrder(@Valid @RequestBody OrderDTO orderDTO) {
        Order order = orderService.updateOrder(orderDTO);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteCommande(@PathVariable("id") Long id) {
        return new ResponseEntity<>(orderService.deleteCommande(id), HttpStatus.OK);
    }
}
