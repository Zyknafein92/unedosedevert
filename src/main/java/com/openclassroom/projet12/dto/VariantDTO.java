package com.openclassroom.projet12.dto;

import com.openclassroom.projet12.model.Reduction;
import com.openclassroom.projet12.model.Stock;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class VariantDTO {

    private Long id;

    private String imageURL;

    private Double prix;

    private Double tva;

    private Reduction reduction;

    private Stock stock;
}
