package com.openclassroom.projet12.dto;

import com.openclassroom.projet12.model.Stock;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotNull;


@Data
@Builder
public class VariantDTO {

    private Long id;

    private ProduitDTO produit;

    private String imageURLOnSelect;

    private String imageURLnonSelect;

    @NotNull(message= "Veuillez renseigner un prix pour le produit !")
    private Double prix;

    @NotNull(message= "Veuillez renseigner un prix au kg pour le produit !")
    private Double prixKg;

    private Double prixReduction;

    @NotNull(message= "Veuillez renseigner la disponibilitée du produit !")
    private Stock stock;
}
