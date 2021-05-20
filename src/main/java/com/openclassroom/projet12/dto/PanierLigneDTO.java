package com.openclassroom.projet12.dto;
import com.openclassroom.projet12.model.Panier;
import com.openclassroom.projet12.model.Produit;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class PanierLigneDTO {

    private Long id;

    @NotNull(message= "Erreur, le produit ne peut pas être null !")
    private VariantDTO variantDTO;

    @NotNull(message= "Veuillez renseigner la quantité du produit !")
    private Integer quantity;

    @NotNull(message= "Veuillez renseigner le prix du produit !")
    private Double prix;
}
