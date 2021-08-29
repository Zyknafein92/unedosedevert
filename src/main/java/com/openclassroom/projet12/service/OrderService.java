package com.openclassroom.projet12.service;



import com.openclassroom.projet12.dto.*;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.*;
import com.openclassroom.projet12.model.*;
import com.openclassroom.projet12.respository.OrderAdressRepository;
import com.openclassroom.projet12.respository.OrderRepository;

import com.openclassroom.projet12.service.specifications.OrderSpecifications;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class OrderService {

    private final UserService userService;
    private final VariantMapper variantMapper;
    private final OrderRepository orderRepository;
    private final OrderAdressRepository orderAdressRepository;
    private final OrderSpecifications orderSpecifications;


    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Page<OrderDTO> getOrdersForAdminBySpecification(Pageable pageable, OrderSpecification orderSpecification) {
        Specification<Order> specification = Specification.where(null);
        if(orderSpecification.getUserEmail() != null && !orderSpecification.getUserEmail().isEmpty()) {
            Specification<Order> userEmailSpecification = orderSpecifications.ordersByUserIdSpecification(orderSpecification.getUserEmail());
            specification = specification.and(userEmailSpecification);
        }
        if(orderSpecification.getOrderStatus() != null) {
            Specification<Order> orderStatusSpecification = orderSpecifications.ordersByOrderStatusSpecification(orderSpecification.getOrderStatus());
            specification = specification.and(orderStatusSpecification);
        }
        if(orderSpecification.getOrderNumber() != null && !orderSpecification.getOrderNumber().isEmpty()) {
            Specification<Order> orderNumberSpecification = orderSpecifications.orderByOrderNumberSpecification(orderSpecification.getOrderNumber());
            specification = specification.and(orderNumberSpecification);
        }
        return orderRepository.findAll(specification,pageable).map(OrderMapper::toOrderDTO);
    }

    public Page<OrderDTO> getOrdersForCurrentUser(String username, Pageable pageable) {
        UserDTO userDTO = userService.findByEmail(username);
        return orderRepository.findAllByUserId(userDTO.getId(), pageable).map(OrderMapper::toOrderDTO);
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("La commande n'existe pas !"));
    }

    public Order orderConfirm(OrderDTO orderDTO, String currentname) {

        List<VariantOrderDTO> variantOrderDTOList = new ArrayList<>();
        UserDTO userDTO =  userService.findByEmail(currentname);

        if (userDTO.getShoppingCart().getShoppingCartLines().isEmpty()) {
            throw new NotFoundException("Le panier est vide");
        }

        OrderAdress deliveryAdress = OrderAdressMapper.AdressDTOtoOrderAdress(orderDTO.getDeliveryAdress());
        OrderAdress billingAdress = OrderAdressMapper.AdressDTOtoOrderAdress(orderDTO.getBillingAdress());

        orderAdressRepository.save(deliveryAdress);
        orderAdressRepository.save(billingAdress);

        for (ShoppingCartLineDTO ligne: userDTO.getShoppingCart().getShoppingCartLines()) {
            Variant variant =  variantMapper.getVariant(ligne.getVariant());
            VariantOrderDTO variantOrderDTOToSave = VariantOrderMapper.variantToVariantCommandeDTO(variant);
            variantOrderDTOToSave.setQuantity(ligne.getQuantity());
            variantOrderDTOList.add(variantOrderDTOToSave);
        }

        List<VariantOrder> variantOrderList = variantOrderDTOList.stream().map(VariantOrderMapper::toVariantCommande).collect(Collectors.toList());

        Order order = Order.builder()
                .id(orderDTO.getId())
                .orderNumber(generateRandomCommandNumber())
                .user(UserMapper.toUser(userDTO))
                .deliveryAdress(deliveryAdress)
                .billingAdress(billingAdress)
                .variantOrderList(variantOrderList)
                .deliveryCharges(5d)
                .total((variantOrderList.stream().map(VariantOrder::calculateTotalPrice).reduce(0d, Double::sum)))
                .date(LocalDateTime.now())
                .orderStatus(OrderStatus.ATTENTE)
                .build();

        order.setTotal(order.getTotal() + order.getDeliveryCharges());
        return orderRepository.save(order);
    }

    public OrderDTO updateOrder(OrderDTO orderDTO) {
        Order order = getOrder(orderDTO.getId());
        OrderMapper.update(orderDTO, order);
        orderRepository.save(order);
        return orderDTO;
    }

    public OrderDTO updateStatusOrder(String orderNumber, OrderStatus orderStatus) {
        Order order = orderRepository.findByOrderNumber(orderNumber);
        order.setOrderStatus(orderStatus);
        orderRepository.save(order);
        return OrderMapper.toOrderDTO(order);
    }

    public Long deleteOrder(Long id) {
        orderRepository.deleteById(id);
        return id;
    }

    public String generateRandomCommandNumber() {
        return RandomStringUtils.randomNumeric(3) + "" + RandomStringUtils.randomAlphabetic(6).toUpperCase();
    }
}
