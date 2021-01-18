package com.openclassroom.projet12.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Data
@Builder
public class ReductionDTO {

    private Long id;

    private Double prixReduit;

    private Integer totalReduction;

    private LocalDate start;

    private LocalDate end;
}
