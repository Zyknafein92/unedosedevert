package com.openclassroom.projet12.dto;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class ShoppingCartLineDTO {

    private Long id;

    @NotNull(message= "Erreur, le variant ne peut pas être null !")
    private VariantDTO variant;

    @NotNull(message= "Erreur, le product ne peut pas être null !")
    private ProductDTO product;

    @NotNull(message= "Veuillez renseigner la quantité du product !")
    private Integer quantity;

    @NotNull(message= "Veuillez renseigner le prix du product !")
    private Double price;
}
