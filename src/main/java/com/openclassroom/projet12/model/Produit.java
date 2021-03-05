package com.openclassroom.projet12.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


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

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message= "Veuillez renseigner un type pour le produit !")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Type type;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull(message= "Veuillez renseigner une categorie pour le produit !")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Categorie categorie;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private SousCategorie sousCategorie;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Tag> tags;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Label> labels;

    @NotNull(message= "Veuillez renseigner une origine pour le produit !")
    private String origine;

    @NotNull(message= "Veuillez renseigner une description pour le produit !")
    private String descriptionProduit;

    private String commentaireProduit;

    @NotNull(message= "Veuillez renseigner les conseils d'utilisations pour le produit !")
    private String conseilUtilisation;

    @NotNull(message= "Veuillez renseigner la composition du produit !")
    private String composition;

    @NotNull(message= "Veuillez renseigner le pourquoi ? du produit !")
    private String pourquoi;

    @NotNull(message= "Veuillez renseigner les informations sur le producteur !")
    private String producteur;

    @NotNull(message= "Veuillez renseigner la valeur et les allergènes du produit !")
    private String allergenes;

    @NotNull(message= "Veuillez renseigner les informations nutritions du produit !")
    private String infoNutrition;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "produit", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<Variant> variants;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    private Reduction reduction;

    private String urlPhoto;
}





