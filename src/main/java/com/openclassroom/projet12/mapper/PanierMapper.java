package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.PanierDTO;
import com.openclassroom.projet12.model.Panier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PanierMapper {

    public static Panier toPanier(PanierDTO panierDTO) {
        return Panier.builder()
                .id(panierDTO.getId())
                .prixTotal(panierDTO.getPrixTotal())
                .build();
    }

    public static void update (PanierDTO panierDTO, Panier entity) {
        entity.setPrixTotal(entity.getPrixTotal());
    }
}


    //private List<PanierLigneDTO> panierLigne;

