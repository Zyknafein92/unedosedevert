package com.openclassroom.projet12.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VariantCommandeDTO {

    private Long id;

    private Long variantID;

    private String name;

    private ProduitDTO produitDTO;

//    private String imageURLOnSelect;
//
//    private String imageURLnonSelect;

    private Double prix;

    private Double prixKg;

    private Integer quantity;

    private Double prixReduction;
}
