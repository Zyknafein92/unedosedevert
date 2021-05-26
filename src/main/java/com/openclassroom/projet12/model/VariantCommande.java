package com.openclassroom.projet12.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_variant_commande")
public class VariantCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long variantID;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Produit produit;

    private String imageURLOnSelect;

    private String imageURLnonSelect;

    private Integer quantity;

    @NotNull(message= "Veuillez renseigner un prix pour le variant!")
    private Double prix;

    @NotNull(message= "Veuillez renseigner un prix au kg pour le variant!")
    private Double prixKg;

    private Double prixReduction;

    public Double calculateTotalPrice () {
        return quantity * prix;
    }
}
