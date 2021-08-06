package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.SubCategorieDTO;
import com.openclassroom.projet12.model.SubCategorie;
import org.springframework.stereotype.Component;

@Component
public class SubCategorieMapper {

    public static SubCategorie toSousCategorie(SubCategorieDTO subCategorieDTO) {
        return SubCategorie.builder()
                .name(subCategorieDTO.getName())
                .build();
    }

    public static SubCategorieDTO toDTO(SubCategorie subCategorie) {
        return SubCategorieDTO.builder()
                .id(subCategorie.getId())
                .name(subCategorie.getName())
                .build();
    }

    public static void update(SubCategorieDTO subCategorieDTO, SubCategorie entity) {
        entity.setName(subCategorieDTO.getName());
    }
}
