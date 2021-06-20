package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.ProduitDTO;
import com.openclassroom.projet12.dto.VariantCommandeDTO;
import com.openclassroom.projet12.model.Produit;
import com.openclassroom.projet12.model.Variant;
import com.openclassroom.projet12.model.VariantCommande;
import org.springframework.stereotype.Component;

@Component
public class VariantCommandeMapper {

    public static VariantCommande toVariantCommande(VariantCommandeDTO variantDTO) {
        return VariantCommande.builder()
                .id(variantDTO.getId())
                .variantID(variantDTO.getVariantID())
                .name(variantDTO.getName())
                .produit(Produit.builder().id(variantDTO.getProduitDTO().getId()).name(variantDTO.getProduitDTO().getName()).build())
                .prix(variantDTO.getPrix())
//                .imageURLnonSelect(variantDTO.getImageURLnonSelect())
//                .imageURLOnSelect(variantDTO.getImageURLOnSelect())
                .prixReduction(variantDTO.getPrixReduction())
                .prixKg(variantDTO.getPrixKg())
                .quantity(variantDTO.getQuantity())
                .build();
    }

    public static VariantCommandeDTO toDTO(VariantCommande variant) {
        return  VariantCommandeDTO.builder()
                .id(variant.getId())
                .variantID(variant.getVariantID())
                .name(variant.getName())
                .produitDTO(ProduitDTO.builder().id(variant.getProduit().getId()).name(variant.getProduit().getName()).build())
                .prix(variant.getPrix())
//                .imageURLnonSelect(variant.getImageURLnonSelect())
//                .imageURLOnSelect(variant.getImageURLOnSelect())
                .prixReduction(variant.getPrixReduction())
                .prixKg(variant.getPrixKg())
                .quantity(variant.getQuantity())
                .build();
    }

    public static void update(VariantCommandeDTO dto, VariantCommande entity){
        entity.setVariantID(entity.getVariantID());
        entity.setPrix(dto.getPrix());
//        entity.setImageURLnonSelect(dto.getImageURLnonSelect());
//        entity.setImageURLOnSelect(dto.getImageURLOnSelect());
        entity.setPrixReduction(dto.getPrixReduction());
        entity.setPrixKg(dto.getPrixKg());
        entity.setName(dto.getName());
        entity.setQuantity(dto.getQuantity());
    }

    public static VariantCommandeDTO variantToVariantCommandeDTO(Variant variant) {
      return VariantCommandeDTO.builder()
              .variantID(variant.getId())
              .name(variant.getName())
              .produitDTO(ProduitDTO.builder().id(variant.getProduit().getId()).name(variant.getProduit().getName()).build())
              .prix(variant.getPrix())
//              .imageURLnonSelect(variant.getImageURLnonSelect())
//              .imageURLOnSelect(variant.getImageURLOnSelect())
              .prixReduction(variant.getPrixReduction())
              .prixKg(variant.getPrixKg())
              .build();
    }
}
