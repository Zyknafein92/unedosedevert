package com.openclassroom.projet12.service;

import com.openclassroom.projet12.dto.CategorieDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.CategorieMapper;
import com.openclassroom.projet12.model.Categorie;
import com.openclassroom.projet12.model.SubCategorie;
import com.openclassroom.projet12.respository.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class CategorieService {

    private final CategorieRepository categorieRepository;
    private final SubCategorieService subCategorieService;

    public List<CategorieDTO> getCategories() {
        return categorieRepository.findAll()
                .stream()
                .map(CategorieMapper::toDTO)
                .sorted((c1, c2) -> (int) (c1.getId() - c2.getId()))
                .collect(Collectors.toList());
    }


    public Page<CategorieDTO> getCategoriePage(Pageable pageable) {
        return categorieRepository.findAll(pageable)
                .map(CategorieMapper::toDTO);
    }

    public Categorie getCategorie(Long id) {
        return categorieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("La catégorie n'existe pas !"));
    }

    public Categorie addCategorie(CategorieDTO categorieDTO) {
        return categorieRepository.save(CategorieMapper.toCategorie(categorieDTO));
    }

    public Categorie updateCategorie(CategorieDTO categorieDTO) {
       Categorie categorie = getCategorie(categorieDTO.getId());
       List<SubCategorie> subCategories = subCategorieService.getSubCategoriesByIds(categorie.getSubCategories().stream().map(SubCategorie::getId).collect(toList()));
       categorie.setSubCategories(subCategories);
       CategorieMapper.update(categorieDTO,categorie);
       return categorieRepository.save(categorie);
    }

    public Long deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
        return id;
    }

    public List<Categorie> getCategoriesByIds(List<Long> ids) {
        return categorieRepository.findAllById(ids);
    }
}
