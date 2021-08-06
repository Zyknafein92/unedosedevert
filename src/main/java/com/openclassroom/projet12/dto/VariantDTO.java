package com.openclassroom.projet12.dto;

import com.openclassroom.projet12.model.Stock;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class VariantDTO {

    private Long id;

    @NotNull(message= "Veuillez renseigner un nom pour le variant!")
    private String name;

    @NotNull(message= "Veuillez renseigner un prix pour le variant!")
    private Double price;

    @NotNull(message= "Veuillez renseigner un prix au kg pour le variant!")
    private Double priceKg;

    private Double reductionPrice;

    @NotNull(message= "Veuillez renseigner la disponibilitée du variant!")
    private Stock stock;
}
