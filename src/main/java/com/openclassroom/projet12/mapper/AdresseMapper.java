package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.AdresseDTO;
import com.openclassroom.projet12.model.Adresse;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class AdresseMapper {

    public static Adresse toAdresse(AdresseDTO dto) {
        return Adresse.builder()
                .nom(dto.getNom())
                .numero(dto.getNumero())
                .voie(dto.getVoie())
                .codePostal(dto.getCodePostal())
                .ville(dto.getVille())
                .batiment(dto.getBatiment())
                .digicode(dto.getDigicode())
                .interphone(dto.getInterphone())
                .etage(dto.getEtage())
                .porte(dto.getPorte())
                .build();
    }

    public static void update(AdresseDTO dto, Adresse entity) {
        entity.setNom(dto.getNom());
        entity.setNumero(dto.getNumero());
        entity.setVoie(dto.getVoie());
        entity.setCodePostal(dto.getCodePostal());
        entity.setVille(dto.getVille());
        entity.setBatiment(dto.getBatiment());
        entity.setDigicode(dto.getDigicode());
        entity.setInterphone(dto.getInterphone());
        entity.setEtage(dto.getEtage());
        entity.setPorte(dto.getPorte());
    }
}
