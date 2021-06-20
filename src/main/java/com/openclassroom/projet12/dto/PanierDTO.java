package com.openclassroom.projet12.dto;


import lombok.Builder;
import lombok.Data;
import java.util.List;


@Data
@Builder
public class PanierDTO {

    private Long id;

    private List<PanierLigneDTO> panierLignes;

    private Double prixTotal;

}
