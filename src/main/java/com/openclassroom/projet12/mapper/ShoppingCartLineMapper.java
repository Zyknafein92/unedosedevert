package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.ShoppingCartLineDTO;
import com.openclassroom.projet12.dto.ProductDTO;
import com.openclassroom.projet12.dto.VariantDTO;
import com.openclassroom.projet12.model.ShoppingCartLine;
import com.openclassroom.projet12.model.Product;
import com.openclassroom.projet12.model.Variant;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartLineMapper {

    public static ShoppingCartLine toPanierLigne(ShoppingCartLineDTO shoppingCartLineDTO) {
        Variant variant = VariantMapper.toVariant(shoppingCartLineDTO.getVariant());
        Product product = ProductMapper.toProduit(shoppingCartLineDTO.getProduct());

        return ShoppingCartLine.builder()
                .id(shoppingCartLineDTO.getId())
                .variant(variant)
                .product(product)
                .price(shoppingCartLineDTO.getPrice())
                .quantity(shoppingCartLineDTO.getQuantity())
                .build();
    }

    public static ShoppingCartLineDTO toPanierLigneDTO(ShoppingCartLine shoppingCartLine) {
        VariantDTO variant = VariantMapper.toDTO(shoppingCartLine.getVariant());
        ProductDTO produit = ProductMapper.toCompleteDTO(shoppingCartLine.getProduct());

        return ShoppingCartLineDTO.builder()
                .id(shoppingCartLine.getId())
                .variant(variant)
                .product(produit)
                .price(shoppingCartLine.getPrice())
                .quantity(shoppingCartLine.getQuantity())
                .build();
    }

    public static void update(ShoppingCartLineDTO shoppingCartLineDTO, ShoppingCartLine entity) {
        entity.setPrice(shoppingCartLineDTO.getPrice());
        entity.setQuantity(shoppingCartLineDTO.getQuantity());
    }
}

