package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.AdressDTO;
import com.openclassroom.projet12.dto.OrderDTO;
import com.openclassroom.projet12.dto.UserDTO;
import com.openclassroom.projet12.dto.VariantOrderDTO;
import com.openclassroom.projet12.model.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public static Order toOrder(OrderDTO orderDTO) {

        List<VariantOrder> variantOrderList = orderDTO.getVariantOrderDTOS().stream().map(VariantOrderMapper::toVariantCommande).collect(Collectors.toList());

        User user = User.builder()
                .id(orderDTO.getUser().getId())
                .build();

        Adress deliveryAdress = Adress.builder()
                .id(orderDTO.getDeliveryAdress().getId())
                .gender(orderDTO.getDeliveryAdress().getGender())
                .adressName(orderDTO.getDeliveryAdress().getAdressName())
                .lastName(orderDTO.getDeliveryAdress().getLastName())
                .firstName(orderDTO.getDeliveryAdress().getFirstName())
                .phone(orderDTO.getDeliveryAdress().getPhone())
                .digicode(orderDTO.getDeliveryAdress().getDigicode())
                .interphone(orderDTO.getDeliveryAdress().getInterphone())
                .appartNumber(orderDTO.getDeliveryAdress().getAppartNumber())
                .floor(orderDTO.getDeliveryAdress().getFloor())
                .building(orderDTO.getDeliveryAdress().getBuilding())
                .number(orderDTO.getDeliveryAdress().getNumber())
                .street(orderDTO.getDeliveryAdress().getStreet())
                .postalCode(orderDTO.getDeliveryAdress().getPostalCode())
                .city(orderDTO.getDeliveryAdress().getCity())
                .build();

        Adress billingAdress = Adress.builder()
                .id(orderDTO.getBillingAdress().getId())
                .gender(orderDTO.getBillingAdress().getGender())
                .adressName(orderDTO.getBillingAdress().getAdressName())
                .lastName(orderDTO.getBillingAdress().getLastName())
                .firstName(orderDTO.getBillingAdress().getFirstName())
                .phone(orderDTO.getBillingAdress().getPhone())
                .digicode(orderDTO.getBillingAdress().getDigicode())
                .interphone(orderDTO.getBillingAdress().getInterphone())
                .appartNumber(orderDTO.getBillingAdress().getAppartNumber())
                .floor(orderDTO.getBillingAdress().getFloor())
                .building(orderDTO.getBillingAdress().getBuilding())
                .number(orderDTO.getBillingAdress().getNumber())
                .street(orderDTO.getBillingAdress().getStreet())
                .postalCode(orderDTO.getBillingAdress().getPostalCode())
                .city(orderDTO.getBillingAdress().getCity())
                .build();

        return Order.builder()
                .id(orderDTO.getId())
                .orderNumber(orderDTO.getOrderNumber())
                .user(user)
                .deliveryAdress(deliveryAdress)
                .billingAdress(billingAdress)
                .variantOrderList(variantOrderList)
                .deliveryCharges(orderDTO.getDeliveryCharges())
                .total(orderDTO.getTotal())
                .date(orderDTO.getDate())
                .orderStatus(orderDTO.getOrderStatus())
                .build();
    }

    public static OrderDTO toOrderDTO(Order order) {
        List<VariantOrderDTO> variantCommandeList = order.getVariantOrderList().stream().map(VariantOrderMapper::toDTO).collect(Collectors.toList());

        UserDTO user = UserDTO.builder()
                .id(order.getUser().getId())
                .build();

        AdressDTO deliveryAddress = AdressDTO.builder()
                .id(order.getDeliveryAdress().getId())
                .gender(order.getDeliveryAdress().getGender())
                .adressName(order.getDeliveryAdress().getAdressName())
                .lastName(order.getDeliveryAdress().getLastName())
                .firstName(order.getDeliveryAdress().getFirstName())
                .phone(order.getDeliveryAdress().getPhone())
                .digicode(order.getDeliveryAdress().getDigicode())
                .interphone(order.getDeliveryAdress().getInterphone())
                .appartNumber(order.getDeliveryAdress().getAppartNumber())
                .floor(order.getDeliveryAdress().getFloor())
                .building(order.getDeliveryAdress().getBuilding())
                .number(order.getDeliveryAdress().getNumber())
                .street(order.getDeliveryAdress().getStreet())
                .postalCode(order.getDeliveryAdress().getPostalCode())
                .city(order.getDeliveryAdress().getCity())
                .build();

        AdressDTO billingAddress = AdressDTO.builder()
                .id(order.getBillingAdress().getId())
                .gender(order.getBillingAdress().getGender())
                .adressName(order.getBillingAdress().getAdressName())
                .lastName(order.getBillingAdress().getLastName())
                .firstName(order.getBillingAdress().getFirstName())
                .phone(order.getBillingAdress().getPhone())
                .digicode(order.getBillingAdress().getDigicode())
                .interphone(order.getBillingAdress().getInterphone())
                .appartNumber(order.getBillingAdress().getAppartNumber())
                .floor(order.getBillingAdress().getFloor())
                .building(order.getBillingAdress().getBuilding())
                .number(order.getBillingAdress().getNumber())
                .street(order.getBillingAdress().getStreet())
                .postalCode(order.getBillingAdress().getPostalCode())
                .city(order.getBillingAdress().getCity())
                .build();


        return OrderDTO.builder()
                .id(order.getId())
                .orderNumber(order.getOrderNumber())
                .user(user)
                .deliveryAdress(deliveryAddress)
                .billingAdress(billingAddress)
                .variantOrderDTOS(variantCommandeList)
                .deliveryCharges(order.getDeliveryCharges())
                .total(order.getTotal())
                .date(order.getDate())
                .orderStatus(order.getOrderStatus())
                .build();
    }

    public static void update(OrderDTO dto, Order entity) {
        entity.setOrderStatus(dto.getOrderStatus());
    }
}



