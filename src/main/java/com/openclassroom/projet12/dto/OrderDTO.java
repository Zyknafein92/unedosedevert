package com.openclassroom.projet12.dto;

import com.openclassroom.projet12.model.OrderStatus;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OrderDTO {

    private Long id;

    private String orderNumber;

    private UserDTO user;

    private AdressDTO deliveryAdress;

    private AdressDTO billingAdress;

    private List<VariantOrderDTO> variantOrderDTOS;

    private Double deliveryCharges;

    private Double total;

    private LocalDateTime date;

    private OrderStatus orderStatus;

}
