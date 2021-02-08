package com.openclassroom.projet12.service;

import com.openclassroom.projet12.dto.SousCategorieDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.SousCategorieMapper;
import com.openclassroom.projet12.model.SousCategorie;

import com.openclassroom.projet12.respository.SousCategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SousCategorieService {

    @Autowired
    private SousCategorieRepository sousCategorieRepository;

    @Autowired
    private SousCategorieMapper sousCategorieMapper;

    public List<SousCategorie> getSousCategories() {
        return sousCategorieRepository.findAll();
    }

    public Page<SousCategorieDTO> getSousContegoriePage(Pageable pageable) {
        return sousCategorieRepository.findAll(pageable)
                .map(sousCat -> sousCategorieMapper.sousCategorieToSousCategorieDTO(sousCat));
    }

    public Optional<SousCategorie> getSousCategorie(Long id) {
        return sousCategorieRepository.findById(id);
    }

    public SousCategorie addSousCategorie(SousCategorieDTO sousCategorieDTO) {
        return sousCategorieRepository.save(sousCategorieMapper.sousCategorieDTOtoSousCategorie(sousCategorieDTO));
    }

    public SousCategorie updateSousCategorie(SousCategorieDTO sousCategorieDTO) {
        Optional<SousCategorie> sousCategorieOptional = getSousCategorie(sousCategorieDTO.getId());
        SousCategorie sousCategorie = null;

        if (sousCategorieOptional.isPresent()) {
            sousCategorie = SousCategorie.builder()
                    .id(sousCategorieOptional.get().getId())
                    .name(sousCategorieOptional.get().getName())
                    .build();
        }
        if (sousCategorie == null) throw new NotFoundException("La sous-catégorie du produit n'existe pas");
        sousCategorieMapper.updateSousCategorieFromSousCategorieDTO(sousCategorieDTO, sousCategorie);
        return sousCategorieRepository.save(sousCategorie);
    }

    public Long deleteSousCategorie(Long id) {
        sousCategorieRepository.deleteById(id);
        return id;
    }
}
