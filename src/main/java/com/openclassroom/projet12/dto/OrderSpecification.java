package com.openclassroom.projet12.dto;

import com.openclassroom.projet12.model.OrderStatus;
import com.openclassroom.projet12.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderSpecification {
    private String orderNumber;
    private String userEmail;
    private OrderStatus orderStatus;
}
