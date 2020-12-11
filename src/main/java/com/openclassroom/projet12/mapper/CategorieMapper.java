package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.CategorieDTO;
import com.openclassroom.projet12.model.Categorie;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CategorieMapper {

    Categorie categorieDTOtoCategorie(CategorieDTO categorieDTO);

    CategorieDTO categorieToCategorieDTO(Categorie categorie);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Categorie updateCategorieFromCategorieDTO(CategorieDTO categorieDTO, @MappingTarget Categorie categorie);
}
