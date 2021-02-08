package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.CategorieDTO;
import com.openclassroom.projet12.dto.SousCategorieDTO;
import com.openclassroom.projet12.model.Categorie;
import com.openclassroom.projet12.model.SousCategorie;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SousCategorieMapper {

    SousCategorie sousCategorieDTOtoSousCategorie(SousCategorieDTO sousCategorieDTO);

    SousCategorieDTO sousCategorieToSousCategorieDTO(SousCategorie sousCategorie);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    SousCategorie updateSousCategorieFromSousCategorieDTO(SousCategorieDTO sousCategorieDTO, @MappingTarget SousCategorie sousCategorie);
}
