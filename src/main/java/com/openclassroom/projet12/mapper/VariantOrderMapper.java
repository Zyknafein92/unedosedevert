package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.ProductDTO;
import com.openclassroom.projet12.dto.VariantOrderDTO;
import com.openclassroom.projet12.model.Product;
import com.openclassroom.projet12.model.Variant;
import com.openclassroom.projet12.model.VariantOrder;
import org.springframework.stereotype.Component;

@Component
public class VariantOrderMapper {

    public static VariantOrder toVariantCommande(VariantOrderDTO variantDTO) {
        Product product = Product.builder()
                .id(variantDTO.getProductDTO().getId())
                .title(variantDTO.getProductDTO().getTitle())
                .urlPicture1(variantDTO.getProductDTO().getUrlPicture1())
                .build();

        return VariantOrder.builder()
                .id(variantDTO.getId())
                .variantID(variantDTO.getVariantID())
                .name(variantDTO.getName())
                .product(product)
                .price(variantDTO.getPrice())
                .reductionPrice(variantDTO.getReductionPrice())
                .priceKg(variantDTO.getPriceKg())
                .quantity(variantDTO.getQuantity())
                .build();
    }

    public static VariantOrderDTO toDTO(VariantOrder variant) {
        ProductDTO product = ProductDTO.builder()
                .id(variant.getProduct().getId())
                .title(variant.getProduct().getTitle())
                .urlPicture1(variant.getProduct().getUrlPicture1())
                .build();

        return  VariantOrderDTO.builder()
                .id(variant.getId())
                .variantID(variant.getVariantID())
                .name(variant.getName())
                .productDTO(product)
                .price(variant.getPrice())
                .reductionPrice(variant.getReductionPrice())
                .priceKg(variant.getPriceKg())
                .quantity(variant.getQuantity())
                .build();
    }

    public static void update(VariantOrderDTO dto, VariantOrder entity){
        entity.setVariantID(entity.getVariantID());
        entity.setPrice(dto.getPrice());
        entity.setReductionPrice(dto.getReductionPrice());
        entity.setPriceKg(dto.getPriceKg());
        entity.setName(dto.getName());
        entity.setQuantity(dto.getQuantity());
    }

    public static VariantOrderDTO variantToVariantCommandeDTO(Variant variant) {
        ProductDTO product = ProductDTO.builder()
                .id(variant.getProduct().getId())
                .title(variant.getProduct().getTitle())
                .urlPicture1(variant.getProduct().getUrlPicture1())
                .build();

        return VariantOrderDTO.builder()
                .variantID(variant.getId())
                .name(variant.getName())
                .productDTO(product)
                .price(variant.getPrice())
                .reductionPrice(variant.getReductionPrice())
                .priceKg(variant.getPriceKg())
                .build();
    }
}
