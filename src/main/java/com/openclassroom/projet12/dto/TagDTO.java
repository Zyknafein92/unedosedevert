package com.openclassroom.projet12.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class TagDTO {

    private Long id;
    @NotNull(message = "Veuillez renseigner un nom pour le tag !")
    private String name;
    @NotNull(message = "Veuillez renseigner une description pour le tag !")
    private String description;
}
