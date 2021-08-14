package com.openclassroom.projet12.controller;


import com.openclassroom.projet12.dto.OrderDTO;
import com.openclassroom.projet12.dto.OrderSpecification;
import com.openclassroom.projet12.model.Order;
import com.openclassroom.projet12.model.OrderStatus;
import com.openclassroom.projet12.service.AuthenticationService;
import com.openclassroom.projet12.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public ResponseEntity<List<Order>> getCommandes() {
        List<Order> orders = orderService.getOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") Long id) {
        return new ResponseEntity<>(orderService.getCommande(id), HttpStatus.OK);
    }

    @GetMapping("/user")
    public Page<OrderDTO> getOrdersForCurrentUser(Pageable pageable) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        return orderService.getOrdersForCurrentUser(currentUsername,pageable);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/admin")
    public Page<OrderDTO> getOrdersForAdminBySpecification(Pageable pageable, @RequestBody(required = false) OrderSpecification orderSpecification) {
        return orderService.getOrdersForAdminBySpecification(pageable, orderSpecification);
    }


    @PostMapping
    public ResponseEntity<Order> orderConfirm(@Valid @RequestBody OrderDTO orderDTO) {
        String currentUsername = authenticationService.getCurrentLoggedInUsername();
        Order orderToCreate = orderService.orderConfirm(orderDTO, currentUsername);
        return new ResponseEntity<>(orderToCreate,HttpStatus.CREATED);

    }

    @PutMapping("/{order}/success")
    public ResponseEntity<Order> updateStatusOrderAfterSuccessPayment(@PathVariable("order")String orderNumber) {
        Order order = orderService.updateStatusOrder(orderNumber,OrderStatus.VALIDE);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    @PutMapping("/{order}/failure")
    public ResponseEntity<Order> updateStatusOrderAfterFailurePayment(@PathVariable("order")String orderNumber) {
        Order order = orderService.updateStatusOrder(orderNumber,OrderStatus.INVALIDE);
        return new ResponseEntity<>(order,HttpStatus.OK);
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
