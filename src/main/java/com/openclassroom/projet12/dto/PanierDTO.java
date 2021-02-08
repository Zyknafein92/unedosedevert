package com.openclassroom.projet12.dto;



import com.openclassroom.projet12.model.PanierLigne;
import lombok.Builder;
import lombok.Data;
import java.util.List;


@Data
@Builder
public class  PanierDTO {

    private Long id;

    private List<PanierLigne> panierLigne;

    private Double prixTotal;

}
