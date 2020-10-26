package com.openclassroom.projet12.mapper;
import com.openclassroom.projet12.dto.PanierLigneDTO;
import com.openclassroom.projet12.model.PanierLigne;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PanierLigneMapper {
    PanierLigne panierLigneDTOtoPanierLigne(PanierLigneDTO panierLigneDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    PanierLigne updatePanierLigneFromPanierLigneDTO(PanierLigneDTO panierLigneDTO, @MappingTarget PanierLigne panierLigne);
}
