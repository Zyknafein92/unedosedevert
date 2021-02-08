package com.openclassroom.projet12.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_variant")
public class Variant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Produit produit;

    private String imageURLOnSelect;

    private String imageURLnonSelect;

    @NotNull(message= "Veuillez renseigner un prix pour le produit !")
    private Double prix;

    @NotNull(message= "Veuillez renseigner un prix au kg pour le produit !")
    private Double prixKg;

    private Double prixReduction;

    @Enumerated(EnumType.STRING)
    @NotNull(message= "Veuillez renseigner la disponibilitée du produit !")
    private Stock stock;
}
