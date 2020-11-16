package com.openclassroom.projet12.service;

import com.openclassroom.projet12.dto.CategorieDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.CategorieMapper;
import com.openclassroom.projet12.model.Categorie;
import com.openclassroom.projet12.respository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private CategorieMapper categorieMapper;

    public List<Categorie> getCategories() {
        return categorieRepository.findAll();
    }

    public Optional<Categorie> getCategorie(Long id) {
        return categorieRepository.findById(id);
    }

    public Categorie addCategorie(CategorieDTO categorieDTO) {
        return categorieRepository.save(categorieMapper.categorieDTOtoCategorie(categorieDTO));
    }

    public Categorie updateCategorie(CategorieDTO categorieDTO) {
        Optional<Categorie> categorieOptional = getCategorie(categorieDTO.getId());
        Categorie categorie = null;

        if(categorieOptional.isPresent()) {
            categorie = Categorie.builder()
                    .id(categorieOptional.get().getId())
                    .name(categorieOptional.get().getName())
                    .build();
        }
        if(categorie == null) throw new NotFoundException("La categorie n'existe pas !");
        categorieRepository.save(categorieMapper.updateCategorieFromCategorieDTO(categorieDTO,categorie));
        return categorie;
    }

    public Long deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
        return id;
    }
}
