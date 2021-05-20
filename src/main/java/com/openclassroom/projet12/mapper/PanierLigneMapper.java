package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.PanierLigneDTO;
import com.openclassroom.projet12.dto.VariantDTO;
import com.openclassroom.projet12.model.PanierLigne;
import com.openclassroom.projet12.model.Variant;
import org.springframework.stereotype.Component;

@Component
public class PanierLigneMapper {

    public static PanierLigne toPanierLigne(PanierLigneDTO panierLigneDTO) {
        return PanierLigne.builder()
                .id(panierLigneDTO.getId())
                .variant(Variant.builder().id(panierLigneDTO.getVariantDTO().getId()).build())
                .prix(panierLigneDTO.getPrix())
                .quantity(panierLigneDTO.getQuantity())
                .build();
    }

    public static PanierLigneDTO toPanierLigneDTO(PanierLigne panierLigne) {
        return PanierLigneDTO.builder()
                .id(panierLigne.getId())
                .variantDTO(VariantDTO.builder().id(panierLigne.getVariant().getId()).build())
                .prix(panierLigne.getPrix())
                .quantity(panierLigne.getQuantity())
                .build();
    }

    public static void update(PanierLigneDTO panierLigneDTO, PanierLigne entity) {
        entity.setPrix(panierLigneDTO.getPrix());
        entity.setQuantity(panierLigneDTO.getQuantity());
    }
}

