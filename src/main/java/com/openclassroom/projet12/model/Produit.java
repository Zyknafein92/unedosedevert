package com.openclassroom.projet12.model;

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

    @OneToOne
    @NotNull(message= "Veuillez renseigner une categorie pour le produit !")
    private Categorie categorie;

    @OneToOne
    @NotNull(message= "Veuillez renseigner un type pour le produit !")
    private Type type;

    @Size(min = 10, max= 500)
    @NotNull(message= "Veuillez renseigner une description pour le produit !")
    private String description;

    @NotNull(message= "Veuillez renseigner une origine pour le produit !")
    private String origine;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Variant> variant;

    @ManyToMany
    private List<Tag> tags;

    @ManyToMany
    private List<TagsCategorie> tagsCategories;

    private String urlPhoto;
}


// Reduction -> prix // date départ // date de fin // taux de remise


