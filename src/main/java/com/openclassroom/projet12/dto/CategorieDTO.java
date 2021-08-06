package com.openclassroom.projet12.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
public class CategorieDTO {
    private Long id;
    @NotNull(message= "Veuillez définir un nom ! (ex: Riz, Légumineuse...)")
    private String name;
    private List<SubCategorieDTO> sousCategories;
}
