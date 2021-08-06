package com.openclassroom.projet12.service;


import com.openclassroom.projet12.dto.*;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.*;
import com.openclassroom.projet12.model.*;
import com.openclassroom.projet12.respository.OrderRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
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

    // Une méthode pour retrouver les orders d'un utilisateur

    private final OrderRepository orderRepository;

    public List<Order> getCommandes() {
        return orderRepository.findAll();
    }

    public Order getCommande(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("La commande n'existe pas !"));
    }

    public Order validerCommande(OrderDTO orderDTO, String currentname) {
        List<VariantOrderDTO> variantOrderDTOList = new ArrayList<>();
        UserDTO userDTO =  userService.findByEmail(currentname);
        ShoppingCartDTO shoppingCartDTO = userDTO.getShoppingCart();
        AdressDTO deliveryAdress = orderDTO.getDeliveryAdress();
        AdressDTO billingAdress = orderDTO.getBillingAdress();

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
                .deliveryAdress(AdressMapper.toAdresse(deliveryAdress))
                .billingAdress(AdressMapper.toAdresse(billingAdress))
                .variantOrderList(variantOrderList)
                .deliveryCharges(5d)
                .total((variantOrderList.stream().map(VariantOrder::calculateTotalPrice).reduce(0d, Double::sum)))
                .date(LocalDateTime.now())
                .orderStatus(OrderStatus.ATTENTE)
                .build();


        order.setTotal(order.getTotal() + order.getDeliveryCharges());
        return orderRepository.save(order);
    }

    public Order updateOrder(OrderDTO orderDTO) {
        Order order = getCommande(orderDTO.getId());
        OrderMapper.update(orderDTO, order);
        return orderRepository.save(order);
    }

    public Order updateStatusOrder(Long id, OrderStatus orderStatus) {
        Order order = getCommande(id);
        order.setOrderStatus(orderStatus);
        return orderRepository.save(order);
    }

    public Long deleteCommande(Long id) {
        orderRepository.deleteById(id);
        return id;
    }

    public String generateRandomCommandNumber() {
        return RandomStringUtils.randomNumeric(3) + "" + RandomStringUtils.randomAlphabetic(6).toUpperCase();
    }

}
