package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.PanierDTO;
import com.openclassroom.projet12.dto.PanierLigneDTO;
import com.openclassroom.projet12.model.Panier;
import com.openclassroom.projet12.model.PanierLigne;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PanierMapper {

    public static Panier toPanier(PanierDTO panierDTO) {
        List<PanierLigne> panierLigneList = panierDTO.getPanierLigneDTOList() == null ? new ArrayList<>() : panierDTO.getPanierLigneDTOList().stream().map(PanierLigneMapper::toPanierLigne).collect(Collectors.toList());

        return Panier.builder()
                .id(panierDTO.getId())
                .panierLigne(panierLigneList)
                .prixTotal(panierDTO.getPrixTotal())
                .build();
    }

    public static PanierDTO toPanierDTO(Panier panier) {

        List<PanierLigneDTO> panierLigneList = panier.getPanierLigne() == null ? new ArrayList<>() : panier.getPanierLigne().stream().map(PanierLigneMapper::toPanierLigneDTO).collect(Collectors.toList());

        return PanierDTO.builder()
                .id(panier.getId())
                .panierLigneDTOList(panierLigneList)
                .prixTotal(panier.getPrixTotal())
                .build();
    }

    public static void update (PanierDTO panierDTO, Panier entity) {
        entity.setPrixTotal(entity.getPrixTotal());
    }
}




