package com.openclassroom.projet12.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VariantOrderDTO {

    private Long id;

    private Long variantID;

    private String name;

    private ProductDTO productDTO;

    private Double price;

    private Double priceKg;

    private Integer quantity;

    private Double reductionPrice;
}
