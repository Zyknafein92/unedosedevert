package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.*;
import com.openclassroom.projet12.model.Produit;
import org.springframework.stereotype.Component;

@Component
public class ProduitMapper {

    public static Produit toProduit(ProduitDTO produitDTO) {
        return Produit.builder()
                .id(produitDTO.getId())
                .name(produitDTO.getName())
                .origine(produitDTO.getOrigine())
                .descriptionProduit(produitDTO.getDescriptionProduit())
                .commentaireProduit(produitDTO.getCommentaireProduit())
                .conseilUtilisation(produitDTO.getConseilUtilisation())
                .composition(produitDTO.getComposition())
                .pourquoi(produitDTO.getPourquoi())
                .producteur(produitDTO.getProducteur())
                .allergenes(produitDTO.getAllergenes())
                .infoNutrition(produitDTO.getInfoNutrition())
                .urlPhoto(produitDTO.getUrlPhoto())
                .build();
    }

    public static ProduitDTO toDTO(Produit produit) {
        return ProduitDTO.builder()
                .id(produit.getId())
                .name(produit.getName())
                .origine(produit.getOrigine())
                .descriptionProduit(produit.getDescriptionProduit())
                .commentaireProduit(produit.getCommentaireProduit())
                .conseilUtilisation(produit.getConseilUtilisation())
                .composition(produit.getComposition())
                .pourquoi(produit.getPourquoi())
                .producteur(produit.getProducteur())
                .allergenes(produit.getAllergenes())
                .infoNutrition(produit.getInfoNutrition())
                .urlPhoto(produit.getUrlPhoto())
                .build();
    }

    public static void update(ProduitDTO dto, Produit entity) {
        entity.setName(dto.getName());
        entity.setOrigine(dto.getOrigine());
        entity.setDescriptionProduit(dto.getDescriptionProduit());
        entity.setCommentaireProduit(dto.getCommentaireProduit());
        entity.setConseilUtilisation(dto.getConseilUtilisation());
        entity.setComposition(dto.getComposition());
        entity.setPourquoi(dto.getPourquoi());
        entity.setProducteur(dto.getProducteur());
        entity.setAllergenes(dto.getAllergenes());
        entity.setInfoNutrition(dto.getInfoNutrition());
        entity.setUrlPhoto(dto.getUrlPhoto());
    }
}

