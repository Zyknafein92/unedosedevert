package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.AdresseDTO;
import com.openclassroom.projet12.dto.CommandeDTO;
import com.openclassroom.projet12.dto.UserDTO;
import com.openclassroom.projet12.dto.VariantCommandeDTO;
import com.openclassroom.projet12.model.*;
import com.openclassroom.projet12.service.UserService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommandeMapper {

    public static Commande toCommande(CommandeDTO commandeDTO) {

        List<VariantCommande> variantCommandeList = commandeDTO.getVariantDTOList().stream().map(VariantCommandeMapper::toVariantCommande).collect(Collectors.toList());

        User user = User.builder()
                .id(commandeDTO.getUserDTO().getId())
                .build();

        Adresse adresse = Adresse.builder()
                .id(commandeDTO.getAdresseDTO().getId())
                .build();

        return Commande.builder()
                .id(commandeDTO.getId())
                .user(user)
                .adresse(adresse)
                .variantCommandeList(variantCommandeList)
                .date(commandeDTO.getDate())
                .livraison(commandeDTO.getLivraison())
                .statusCommande(commandeDTO.getStatusCommande())
                .modeReglement(commandeDTO.getModeReglement())
                .total(commandeDTO.getTotal())
                .build();
    }

    public static CommandeDTO toCommandeDTO(Commande commande) {
        List<VariantCommandeDTO> variantCommandeList = commande.getVariantCommandeList().stream().map(VariantCommandeMapper::toDTO).collect(Collectors.toList());

        UserDTO userDTO = UserDTO.builder()
                .id(commande.getUser().getId())
                .build();

        AdresseDTO adresseDTO = AdresseDTO.builder()
                .id(commande.getAdresse().getId())
                .build();

        return CommandeDTO.builder()
                .id(commande.getId())
                .userDTO(userDTO)
                .adresseDTO(adresseDTO)
                .variantDTOList(variantCommandeList)
                .date(commande.getDate())
                .livraison(commande.getLivraison())
                .statusCommande(commande.getStatusCommande())
                .modeReglement(commande.getModeReglement())
                .total(commande.getTotal())
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



