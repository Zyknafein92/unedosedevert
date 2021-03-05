package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.VariantDTO;
import com.openclassroom.projet12.model.Variant;
import org.springframework.stereotype.Component;

@Component
public class VariantMapper {

    public static Variant toVariant(VariantDTO variantDTO) {
        return Variant.builder()
                .prix(variantDTO.getPrix())
                .imageURLnonSelect(variantDTO.getImageURLnonSelect())
                .imageURLOnSelect(variantDTO.getImageURLOnSelect())
                .prixReduction(variantDTO.getPrixReduction())
                .prixKg(variantDTO.getPrixKg())
                .stock(variantDTO.getStock())
                .build();
    }

    public static void update(VariantDTO dto, Variant entity){
        entity.setPrix(dto.getPrix());
        entity.setImageURLnonSelect(dto.getImageURLnonSelect());
        entity.setImageURLOnSelect(dto.getImageURLOnSelect());
        entity.setPrixReduction(dto.getPrixReduction());
        entity.setPrixKg(dto.getPrixKg());
        entity.setStock(dto.getStock());
    }
}
