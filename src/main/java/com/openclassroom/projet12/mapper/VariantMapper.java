package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.VariantDTO;
import com.openclassroom.projet12.model.Variant;
import org.springframework.stereotype.Component;

@Component
public class VariantMapper {

    public static Variant toVariant(VariantDTO variantDTO) {
        return Variant.builder()
                .id(variantDTO.getId())
                .name(variantDTO.getName())
                .prix(variantDTO.getPrix())
                .prixReduction(variantDTO.getPrixReduction())
                .prixKg(variantDTO.getPrixKg())
                .stock(variantDTO.getStock())
                .build();
    }

    public static VariantDTO toDTO(Variant variant) {
        return VariantDTO.builder()
                .id(variant.getId())
                .name(variant.getName())
                .prix(variant.getPrix())
                .prixReduction(variant.getPrixReduction())
                .prixKg(variant.getPrixKg())
                .stock(variant.getStock())
                .build();
    }

    public static void update(VariantDTO dto, Variant entity){
        entity.setPrix(dto.getPrix());
        entity.setPrixReduction(dto.getPrixReduction());
        entity.setPrixKg(dto.getPrixKg());
        entity.setStock(dto.getStock());
        entity.setName(dto.getName());
    }
}
