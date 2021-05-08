package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.AdresseDTO;
import com.openclassroom.projet12.model.Adresse;
import org.springframework.stereotype.Component;

@Component
public class AdresseMapper {

    public static Adresse toAdresse(AdresseDTO dto) {
        return Adresse.builder()
                .id(dto.getId())
                .genre(dto.getGenre())
                .nomAdresse(dto.getNomAdresse())
                .nom(dto.getNom())
                .prenom(dto.getPrenom())
                .phone(dto.getPhone())
                .digicode(dto.getDigicode())
                .interphone(dto.getInterphone())
                .etage(dto.getEtage())
                .batiment(dto.getBatiment())
                .numero(dto.getNumero())
                .voie(dto.getVoie())
                .codePostal(dto.getCodePostal())
                .ville(dto.getVille())
                .information(dto.getInformation())
                .livraison(dto.getLivraison())
                .facturation(dto.getFacturation())
                .build();
    }

    public static AdresseDTO toAdresseDTO (Adresse adresse) {
        return AdresseDTO.builder()
                .id(adresse.getId())
                .genre(adresse.getGenre())
                .nomAdresse(adresse.getNomAdresse())
                .nom(adresse.getNom())
                .prenom(adresse.getPrenom())
                .phone(adresse.getPhone())
                .digicode(adresse.getDigicode())
                .interphone(adresse.getInterphone())
                .etage(adresse.getEtage())
                .batiment(adresse.getBatiment())
                .numero(adresse.getNumero())
                .voie(adresse.getVoie())
                .codePostal(adresse.getCodePostal())
                .ville(adresse.getVille())
                .information(adresse.getInformation())
                .livraison(adresse.getLivraison())
                .facturation(adresse.getFacturation())
                .build();
    }

    public static void update(AdresseDTO dto, Adresse entity) {
        entity.setGenre(dto.getGenre());
        entity.setNomAdresse(dto.getNomAdresse());
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setPhone(dto.getPhone());
        entity.setDigicode(dto.getDigicode());
        entity.setInterphone(dto.getInterphone());
        entity.setEtage(dto.getEtage());
        entity.setBatiment(dto.getBatiment());
        entity.setNumero(dto.getNumero());
        entity.setVoie(dto.getVoie());
        entity.setCodePostal(dto.getCodePostal());
        entity.setVille(dto.getVille());
        entity.setInformation(dto.getInformation());
        entity.setLivraison(dto.getLivraison());
        entity.setFacturation(dto.getFacturation());
    }
}
