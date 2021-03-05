package com.openclassroom.projet12.service;

import com.openclassroom.projet12.dto.SousCategorieDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.SousCategorieMapper;
import com.openclassroom.projet12.model.SousCategorie;
import com.openclassroom.projet12.respository.SousCategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@AllArgsConstructor
public class SousCategorieService {

    private final SousCategorieRepository sousCategorieRepository;

    public SousCategorie getSousCategorie(Long id) {
        return sousCategorieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("La sous-catégorie du produit n'éxiste pas"));
    }

    public List<SousCategorie> getSousCategories() {
        return sousCategorieRepository.findAll();
    }

    public List<SousCategorie> getSousCategoriesByIds(List<Long> ids) {
        return sousCategorieRepository.findAllById(ids);
    }

    public Page<SousCategorieDTO> getSousContegoriePage(Pageable pageable) {
        return sousCategorieRepository.findAll(pageable)
                .map(SousCategorieMapper::toDTO);
    }

    public SousCategorie addSousCategorie(SousCategorieDTO sousCategorieDTO) {
        return sousCategorieRepository.save(SousCategorieMapper.toSousCategorie(sousCategorieDTO));
    }

    public SousCategorie updateSousCategorie(SousCategorieDTO sousCategorieDTO) {
        SousCategorie sousCategorie = getSousCategorie(sousCategorieDTO.getId());
        SousCategorieMapper.update(sousCategorieDTO, sousCategorie);
        return sousCategorieRepository.save(sousCategorie);
    }

    public Long deleteSousCategorie(Long id) {
        sousCategorieRepository.deleteById(id);
        return id;
    }
}
