package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.CategorieDTO;
import com.openclassroom.projet12.model.Categorie;
import org.springframework.stereotype.Component;

@Component
public class CategorieMapper {

    public static Categorie toCategorie(CategorieDTO categorieDTO) {
        return Categorie.builder()
                .name(categorieDTO.getName())
                .build();
    }

    public static void update(CategorieDTO dto, Categorie entity) {
        entity.setName(dto.getName());
    }

    public static CategorieDTO toDTO(Categorie c) {
        return CategorieDTO.builder()
                .name(c.getName())
                .build();  }
}
