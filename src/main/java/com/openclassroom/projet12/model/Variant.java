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

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Produit produit;

    private String imageURLOnSelect;

    private String imageURLnonSelect;

    @NotNull(message= "Veuillez renseigner un prix pour le variant!")
    private Double prix;

    @NotNull(message= "Veuillez renseigner un prix au kg pour le variant!")
    private Double prixKg;

    private Double prixReduction;

    @Enumerated(EnumType.STRING)
    @NotNull(message= "Veuillez renseigner la disponibilitée du variant!")
    private Stock stock;
}
