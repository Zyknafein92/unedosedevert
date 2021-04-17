package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.*;
import com.openclassroom.projet12.model.Label;
import com.openclassroom.projet12.model.Produit;
import com.openclassroom.projet12.model.Tag;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
                .commentaireProducteur(produitDTO.getCommentaireProducteur())
                .allergenes(produitDTO.getAllergenes())
                .infoNutrition(produitDTO.getInfoNutrition())
                .urlPetitePhoto(produitDTO.getUrlPetitePhoto())
                .urlGrandePhoto(produitDTO.getUrlGrandePhoto())
                .build();
    }

    public static ProduitDTO toDTO(Produit produit) {
        return ProduitDTO.builder()
                .id(produit.getId())
                .name(produit.getName())
                .type(TypeDTO.builder().name(produit.getType().getName()).build())
                .categorie(CategorieDTO.builder().name(produit.getCategorie().getName()).build())
                .origine(produit.getOrigine())
                .descriptionProduit(produit.getDescriptionProduit())
                .commentaireProduit(produit.getCommentaireProduit())
                .conseilUtilisation(produit.getConseilUtilisation())
                .composition(produit.getComposition())
                .pourquoi(produit.getPourquoi())
                .producteur(produit.getProducteur())
                .commentaireProducteur(produit.getCommentaireProducteur())
                .allergenes(produit.getAllergenes())
                .infoNutrition(produit.getInfoNutrition())
                .urlPetitePhoto(produit.getUrlPetitePhoto())
                .urlGrandePhoto(produit.getUrlGrandePhoto())
                .build();
    }

    public static ProduitDTO toCompleteDTO(Produit produit) {
        TypeDTO type = TypeDTO.builder()
                .id(produit.getType().getId())
                .name(produit.getType().getName())
                .build();

        CategorieDTO categorieDTO = CategorieDTO.builder()
                .id(produit.getCategorie().getId())
                .name(produit.getCategorie().getName())
                .build();

        SousCategorieDTO sousCategorieDTO = SousCategorieDTO.builder()
                .id(produit.getSousCategorie().getId())
                .name(produit.getSousCategorie().getName())
                .build();

        List<TagDTO> tagDTOList = produit.getTags().stream().map(TagMapper::toDTO).collect(Collectors.toList());

        List<LabelDTO> labelDTOList = produit.getLabels().stream().map(LabelMapper::toDTO).collect(Collectors.toList());

        List<VariantDTO> variantDTOList = produit.getVariants().stream().map(VariantMapper::toDTO).collect(Collectors.toList());

        return ProduitDTO.builder()
                .id(produit.getId())
                .name(produit.getName())
                .type(type)
                .categorie(categorieDTO)
                .sousCategorie(sousCategorieDTO)
                .origine(produit.getOrigine())
                .descriptionProduit(produit.getDescriptionProduit())
                .commentaireProduit(produit.getCommentaireProduit())
                .conseilUtilisation(produit.getConseilUtilisation())
                .composition(produit.getComposition())
                .pourquoi(produit.getPourquoi())
                .producteur(produit.getProducteur())
                .commentaireProducteur(produit.getCommentaireProducteur())
                .allergenes(produit.getAllergenes())
                .infoNutrition(produit.getInfoNutrition())
                .urlPetitePhoto(produit.getUrlPetitePhoto())
                .urlGrandePhoto(produit.getUrlGrandePhoto())
                .variants(variantDTOList)
                .tags(tagDTOList)
                .labels(labelDTOList)
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
        entity.setCommentaireProducteur(dto.getCommentaireProducteur());
        entity.setAllergenes(dto.getAllergenes());
        entity.setInfoNutrition(dto.getInfoNutrition());
        entity.setUrlPetitePhoto(dto.getUrlPetitePhoto());
        entity.setUrlGrandePhoto(dto.getUrlGrandePhoto());
    }
}

