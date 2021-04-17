package com.openclassroom.projet12.dto;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ProduitDTO {

    private Long id;

    @NotNull(message= "Veuillez renseigner un nom pour le produit !")
    private String name;

    @NotNull(message= "Veuillez renseigner un type pour le produit !")
    private TypeDTO type;

    @NotNull(message= "Veuillez renseigner une categorie pour le produit !")
    private CategorieDTO categorie;

    private SousCategorieDTO sousCategorie;

    private List<TagDTO> tags;

    private List<LabelDTO> labels;

    @NotNull(message= "Veuillez renseigner une origine pour le produit !")
    @Size(max = 800, message = "Le texte ne peut pas dépasser les 800 charactères..")
    private String origine;

    @NotNull(message= "Veuillez renseigner une description pour le produit !")
    @Size(max = 800, message = "Le texte ne peut pas dépasser les 800 charactères..")
    private String descriptionProduit;

    @Size(max = 800, message = "Le texte ne peut pas dépasser les 800 charactères..")
    private String commentaireProduit;

    @NotNull(message= "Veuillez renseigner les conseils d'utilisations pour le produit !")
    @Size(max = 800, message = "Le texte ne peut pas dépasser les 800 charactères..")
    private String conseilUtilisation;

    @NotNull(message= "Veuillez renseigner la composition du produit !")
    @Size(max = 800, message = "Le texte ne peut pas dépasser les 800 charactères..")
    private String composition;

    @NotNull(message= "Veuillez renseigner le pourquoi ? du produit !")
    @Size(max = 800, message = "Le texte ne peut pas dépasser les 800 charactères..")
    private String pourquoi;

    @NotNull(message= "Veuillez renseigner le nom du producteur !")
    @Size(max = 100, message = "Le texte ne peut pas dépasser les 100 charactères..")
    private String producteur;

    @NotNull(message= "Veuillez renseigner les informations sur le producteur !")
    @Size(max = 800, message = "Le texte ne peut pas dépasser les 800 charactères..")
    private String commentaireProducteur;

    @NotNull(message= "Veuillez renseigner la valeur et les allergènes du produit !")
    @Size(max = 800, message = "Le texte ne peut pas dépasser les 800 charactères..")
    private String allergenes;

    @NotNull(message= "Veuillez renseigner les informations nutritions du produit !")
    @Size(max = 800, message = "Le texte ne peut pas dépasser les 800 charactères..")
    private String infoNutrition;

    private List<VariantDTO> variants;

    private ReductionDTO reduction;

    private String urlPetitePhoto;

    private String urlGrandePhoto;
}
