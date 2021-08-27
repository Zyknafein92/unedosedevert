package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.ShoppingCartDTO;
import com.openclassroom.projet12.dto.ShoppingCartLineDTO;
import com.openclassroom.projet12.model.ShoppingCart;
import com.openclassroom.projet12.model.ShoppingCartLine;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShoppingCartMapper {

    public static ShoppingCart toShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        List<ShoppingCartLine> shoppingCartLineList = shoppingCartDTO.getShoppingCartLines().stream().map(ShoppingCartLineMapper::toShoppingCartLine).collect(Collectors.toList());

        return ShoppingCart.builder()
                .id(shoppingCartDTO.getId())
                .shoppingCartLines(shoppingCartLineList)
                .build();
    }

    public static ShoppingCartDTO toShoppingCartDTO(ShoppingCart shoppingCart) {

        List<ShoppingCartLineDTO> panierLigneList = shoppingCart.getShoppingCartLines().stream().map(ShoppingCartLineMapper::toShoppingCartLineDTO).collect(Collectors.toList());

        return ShoppingCartDTO.builder()
                .id(shoppingCart.getId())
                .shoppingCartLines(panierLigneList)
                .build();
    }
}




