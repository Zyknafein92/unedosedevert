package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.PanierLigneDTO;
import com.openclassroom.projet12.model.PanierLigne;
import org.springframework.stereotype.Component;

@Component
public class PanierLigneMapper {

    public static PanierLigne toPanierLigne(PanierLigneDTO panierLigneDTO) {
        return PanierLigne.builder()
                .prix(panierLigneDTO.getPrix())
                .quantity(panierLigneDTO.getQuantity())
                .build();
    }

    public static void update(PanierLigneDTO panierLigneDTO, PanierLigne entity) {
        entity.setPrix(panierLigneDTO.getPrix());
        entity.setQuantity(panierLigneDTO.getQuantity());
    }
}

// private ProduitDTO produit;
