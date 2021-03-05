package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.CommandeDTO;
import com.openclassroom.projet12.model.Commande;
import org.springframework.stereotype.Component;

@Component
public class CommandeMapper {

    public static Commande toCommande(CommandeDTO commandeDTO) {
        return Commande.builder()
                .date(commandeDTO.getDate())
                .livraison(commandeDTO.getLivraison())
                .statusCommande(commandeDTO.getStatusCommande())
                .modeReglement(commandeDTO.getModeReglement())
                .total(commandeDTO.getTotal())
                .build();
    }

    public static void update(CommandeDTO dto, Commande entity) {
        entity.setDate(dto.getDate());
        entity.setLivraison(dto.getLivraison());
        entity.setStatusCommande(dto.getStatusCommande());
        entity.setModeReglement(dto.getModeReglement());
        entity.setTotal(dto.getTotal());
    }
}


    //private User user;
