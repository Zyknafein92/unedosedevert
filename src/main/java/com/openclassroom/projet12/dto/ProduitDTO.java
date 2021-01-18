package com.openclassroom.projet12.dto;
import com.openclassroom.projet12.model.*;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
public class ProduitDTO {

    private Long id;

    @NotNull(message= "Veuillez renseigner un nom pour le produit !")
    private String name;

    @NotNull(message= "Veuillez renseigner une categorie pour le produit !")
    private Categorie categorie;

    @NotNull(message= "Veuillez renseigner un type pour le produit !")
    private Type type;

    @NotNull(message= "Veuillez renseigner une description pour le produit !")
    private String description;

    @NotNull(message= "Veuillez renseigner une origine pour le produit !")
    private String origine;

    private List<Variant> variants;

    private List<Tag> tags;

    private List<TagsCategorie> tagsCategorie;

    private String urlPhoto;

}
