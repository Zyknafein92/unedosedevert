package com.openclassroom.projet12.dto;


import lombok.Builder;
import lombok.Data;
import java.util.List;


@Data
@Builder
public class ShoppingCartDTO {

    private Long id;

    private List<ShoppingCartLineDTO> shoppingCartLines;

    private Double totalPrice;

}
