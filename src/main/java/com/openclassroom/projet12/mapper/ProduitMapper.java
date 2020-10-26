package com.openclassroom.projet12.mapper;


import com.openclassroom.projet12.dto.ProduitDTO;
import com.openclassroom.projet12.model.Produit;
import org.mapstruct.*;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProduitMapper {

    Produit produitDTOtoProduit(ProduitDTO produitDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Produit updateProduitFromProduitDTO(ProduitDTO produitDTO, @MappingTarget Produit produit);
}