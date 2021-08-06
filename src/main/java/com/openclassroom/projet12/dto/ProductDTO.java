package com.openclassroom.projet12.dto;
import com.openclassroom.projet12.model.*;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
public class ProductDTO {

    private Long id;

    @NotNull(message= "Veuillez renseigner un nom pour le product !")
    private String title;

    @NotNull(message= "Veuillez renseigner une marque pour le product !")
    private String brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message= "Veuillez renseigner un type pour le product !")
    private TypeDTO type;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message= "Veuillez renseigner une categorie pour le product !")
    private CategorieDTO categorie;

    @ManyToOne(fetch = FetchType.LAZY)
    private SubCategorieDTO subCategorie;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<TagDTO> tags;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<LabelDTO> labels;

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

    private List<VariantDTO> variants;

    private Reduction reduction;

    private String urlPicture1;

    private String urlPicture2;

    private String urlPicture3;
}
