package com.openclassroom.projet12.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
@Builder
public class ReductionDTO {

    private Long id;
    @NotNull(message= "La valeur de la réduction doit être définie")
    private Integer reduction;
    @NotNull(message= "La date de début de la réduction doit être définie")
    private LocalDate reductionStart;
    @NotNull(message= "La date de fin de la réduction doit être définie")
    private LocalDate reductionEnd;
}
