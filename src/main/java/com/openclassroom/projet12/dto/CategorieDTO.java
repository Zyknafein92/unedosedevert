package com.openclassroom.projet12.dto;

import com.openclassroom.projet12.model.SousCategorie;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class CategorieDTO {
    private Long id;
    @NotNull(message= "Veuillez définir un nom ! (ex: Riz, Légumineuse...)")
    private String name;
    private List<SousCategorieDTO> sousCategories;
}
