package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.VariantDTO;
import com.openclassroom.projet12.model.Product;
import com.openclassroom.projet12.model.Variant;
import com.openclassroom.projet12.respository.VariantRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class VariantMapper {

    @Autowired
    private VariantRepository repository;

    public Variant getVariant(VariantDTO variantDTO) {
        return repository.findById(variantDTO.getId()).get();
    }

    public static Variant toVariant(VariantDTO variantDTO) {
        return Variant.builder()
                .id(variantDTO.getId())
                .name(variantDTO.getName())
                .price(variantDTO.getPrice())
                .reductionPrice(variantDTO.getReductionPrice())
                .priceKg(variantDTO.getPriceKg())
                .stock(variantDTO.getStock())
                .build();
    }

    public static VariantDTO toDTO(Variant variant) {
        return VariantDTO.builder()
                .id(variant.getId())
                .name(variant.getName())
                .price(variant.getPrice())
                .reductionPrice(variant.getReductionPrice())
                .priceKg(variant.getPriceKg())
                .stock(variant.getStock())
                .build();
    }

    public static void update(VariantDTO dto, Variant entity){
        entity.setPrice(dto.getPrice());
        entity.setReductionPrice(dto.getReductionPrice());
        entity.setPriceKg(dto.getPriceKg());
        entity.setStock(dto.getStock());
        entity.setName(dto.getName());
    }
}
