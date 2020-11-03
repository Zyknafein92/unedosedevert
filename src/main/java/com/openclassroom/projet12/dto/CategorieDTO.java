package com.openclassroom.projet12.dto;

import com.openclassroom.projet12.model.Categorie;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategorieDTO {
    private Categorie categorie;
    private String description;
}
