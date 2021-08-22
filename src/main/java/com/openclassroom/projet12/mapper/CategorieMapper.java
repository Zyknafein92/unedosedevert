package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.CategorieDTO;
import com.openclassroom.projet12.dto.SubCategorieDTO;
import com.openclassroom.projet12.model.Categorie;
import com.openclassroom.projet12.model.SubCategorie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

        List<SubCategorieDTO> subCategories = c.getSubCategories().stream().map(SubCategorieMapper::toDTO).collect(Collectors.toList());

        return CategorieDTO.builder()
                .id(c.getId())
                .name(c.getName())
                .sousCategories(subCategories)
                .build();  }
}
