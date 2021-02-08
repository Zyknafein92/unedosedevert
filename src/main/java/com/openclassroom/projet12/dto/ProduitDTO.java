package com.openclassroom.projet12.dto;
import com.openclassroom.projet12.model.*;
import lombok.Builder;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
public class ProduitDTO {

    private Long id;

    @NotNull(message= "Veuillez renseigner un nom pour le produit !")
    private String name;

    @NotNull(message= "Veuillez renseigner un type pour le produit !")
    private Type type;

    @NotNull(message= "Veuillez renseigner une categorie pour le produit !")
    private Categorie categorie;

    @NotNull(message= "Veuillez renseigner une sous-categorie pour le produit !")
    private SousCategorie sousCategorie;

    private List<Tag> tags;

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
    private String allergènes;

    @NotNull(message= "Veuillez renseigner les informations nutritions du produit !")
    private String infoNutrition;

    private List<Variant> variant;

    private Reduction reduction;

    private String urlPhoto;

}
