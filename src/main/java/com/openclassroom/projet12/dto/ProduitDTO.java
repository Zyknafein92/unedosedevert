package com.openclassroom.projet12.dto;
import com.openclassroom.projet12.model.Categorie;
import com.openclassroom.projet12.model.Stock;
import com.openclassroom.projet12.model.Type;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotNull;

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

    @NotNull(message= "Veuillez renseigner un prix HT pour le produit !")
    private Double prix;

    @NotNull(message= "Veuillez renseigner la tva pour le produit !")
    private Double tva;

    @NotNull(message= "Veuillez renseigner la disponibilitée du produit !")
    private Stock stock;


}
