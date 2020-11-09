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
@Table(name = "t_produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message= "Veuillez renseigner un nom pour le produit !")
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull(message= "Veuillez renseigner une categorie pour le produit !")
    private Categorie categorie;

    @Enumerated(EnumType.STRING)
    @NotNull(message= "Veuillez renseigner un type pour le produit !")
    private Type type;

    @Size(min = 10, max= 500)
    @NotNull(message= "Veuillez renseigner une description pour le produit !")
    private String description;

    @NotNull(message= "Veuillez renseigner une origine pour le produit !")
    private String origine;

    @NotNull(message= "Veuillez renseigner un prix HT pour le produit !")
    private Double prix;

    @NotNull(message= "Veuillez renseigner la tva pour le produit !")
    private Double tva;

    @Enumerated(EnumType.STRING)
    @NotNull(message= "Veuillez renseigner la disponibilitée du produit !")
    private Stock stock;

}
