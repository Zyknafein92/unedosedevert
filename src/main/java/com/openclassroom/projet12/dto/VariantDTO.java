package com.openclassroom.projet12.dto;

import com.openclassroom.projet12.model.Produit;
import com.openclassroom.projet12.model.Reduction;
import com.openclassroom.projet12.model.Stock;
import lombok.Builder;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
public class VariantDTO {

    private Long id;

    private Produit produit;

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
