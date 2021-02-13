package com.openclassroom.projet12.service;

import com.openclassroom.projet12.dto.CategorieDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.CategorieMapper;
import com.openclassroom.projet12.model.Categorie;
import com.openclassroom.projet12.model.Produit;
import com.openclassroom.projet12.respository.CategorieRepository;
import com.openclassroom.projet12.respository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private CategorieMapper categorieMapper;
    @Autowired
    private ProduitRepository produitRepository;

    public List<CategorieDTO> getCategories() {
        return categorieRepository.findAll()
                .stream()
                .map(cat -> {
                    CategorieDTO catDTO = categorieMapper.categorieToCategorieDTO(cat);
                    return catDTO;
                })
                .collect(Collectors.toList());
    }

    public Page<CategorieDTO> getCategoriePage(Pageable pageable) {
        return categorieRepository.findAll(pageable)
                .map(cat -> categorieMapper.categorieToCategorieDTO(cat));
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
                    .sousCategories(categorieOptional.get().getSousCategories())
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
