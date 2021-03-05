package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.SousCategorieDTO;
import com.openclassroom.projet12.model.SousCategorie;
import org.springframework.stereotype.Component;

@Component
public class SousCategorieMapper {

    public static SousCategorie toSousCategorie(SousCategorieDTO sousCategorieDTO) {
        return SousCategorie.builder()
                .name(sousCategorieDTO.getName())
                .build();
    }

    public static SousCategorieDTO toDTO(SousCategorie sousCategorie) {
        return SousCategorieDTO.builder()
                .id(sousCategorie.getId())
                .name(sousCategorie.getName())
                .build();
    }

    public static void update(SousCategorieDTO sousCategorieDTO, SousCategorie entity) {
        entity.setName(sousCategorieDTO.getName());
    }
}
