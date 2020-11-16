package com.openclassroom.projet12.dto;

import com.openclassroom.projet12.model.Categorie;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
public class TypeDTO {
    private Long id;
    @NotNull(message= "Veuillez définir un nom ! (ex: Alimentaire, Cosmétique...)")
    private String name;
    private List<Categorie> categories;
}
