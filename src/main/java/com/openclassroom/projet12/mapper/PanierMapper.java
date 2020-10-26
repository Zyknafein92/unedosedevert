package com.openclassroom.projet12.mapper;


import com.openclassroom.projet12.dto.PanierDTO;
import com.openclassroom.projet12.model.Panier;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PanierMapper {

    Panier panierDTOtoPanier(PanierDTO panierDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Panier updatePanierFromPanierDTO(PanierDTO panierDTO, @MappingTarget Panier panier);
}

