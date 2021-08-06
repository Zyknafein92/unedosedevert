package com.openclassroom.projet12.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message= "Veuillez renseigner un nom pour le product !")
    private String title;

    @NotNull(message= "Veuillez renseigner une marque pour le product !")
    private String brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message= "Veuillez renseigner un type pour le product !")
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message= "Veuillez renseigner une categorie pour le product !")
    private Categorie categorie;

    @ManyToOne(fetch = FetchType.LAZY)
    private SubCategorie subCategorie;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Tag> tags;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Label> labels;

    @NotNull(message= "Veuillez renseigner une origine pour le product !")
    private String origin;

    @NotNull(message= "Veuillez renseigner une description pour le product !")
    @Size(max = 800, message = "Le texte ne peut pas dépasser les 800 charactères..")
    private String productDescription;


    @Size(max = 800, message = "Le texte ne peut pas dépasser les 800 charactères..")
    private String utilisationAdvice;

    @NotNull(message= "Veuillez renseigner la composition du product !")
    @Size(max = 800, message = "Le texte ne peut pas dépasser les 800 charactères..")
    private String composition;

    @Size(max = 800, message = "Le texte ne peut pas dépasser les 800 charactères..")
    private String whyThisProduct;

    private String producer;

    private String producerComment;

    @Size(max = 800, message = "Le texte ne peut pas dépasser les 800 charactères..")
    private String allergen;

    @Size(max = 800, message = "Le texte ne peut pas dépasser les 800 charactères..")
    private String nutritionalInformation;

    private String additionalInformation;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Variant> variants = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.REMOVE)
    private Reduction reduction;

    private String urlPicture1;

    private String urlPicture2;

    private String urlPicture3;
}





