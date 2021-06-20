package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.PanierLigneDTO;
import com.openclassroom.projet12.dto.ProduitDTO;
import com.openclassroom.projet12.dto.VariantDTO;
import com.openclassroom.projet12.model.PanierLigne;
import com.openclassroom.projet12.model.Produit;
import com.openclassroom.projet12.model.Variant;
import org.springframework.stereotype.Component;

@Component
public class PanierLigneMapper {

    public static PanierLigne toPanierLigne(PanierLigneDTO panierLigneDTO) {
        Variant variant = VariantMapper.toVariant(panierLigneDTO.getVariant());
        Produit produit = ProduitMapper.toProduit(panierLigneDTO.getProduit());

        return PanierLigne.builder()
                .id(panierLigneDTO.getId())
                .variant(variant)
                .produit(produit)
                .prix(panierLigneDTO.getPrix())
                .quantity(panierLigneDTO.getQuantity())
                .build();
    }

    public static PanierLigneDTO toPanierLigneDTO(PanierLigne panierLigne) {
        VariantDTO variant = VariantMapper.toDTO(panierLigne.getVariant());
        ProduitDTO produit = ProduitMapper.toCompleteDTO(panierLigne.getProduit());

        return PanierLigneDTO.builder()
                .id(panierLigne.getId())
                .variant(variant)
                .produit(produit)
                .prix(panierLigne.getPrix())
                .quantity(panierLigne.getQuantity())
                .build();
    }

    public static void update(PanierLigneDTO panierLigneDTO, PanierLigne entity) {
        entity.setPrix(panierLigneDTO.getPrix());
        entity.setQuantity(panierLigneDTO.getQuantity());
    }
}

