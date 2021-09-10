package com.openclassroom.projet12.service;

import com.openclassroom.projet12.dto.SubCategorieDTO;
import com.openclassroom.projet12.exceptions.ErrorCode;
import com.openclassroom.projet12.exceptions.NotEmptyException;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.SubCategorieMapper;
import com.openclassroom.projet12.model.Product;
import com.openclassroom.projet12.model.SubCategorie;
import com.openclassroom.projet12.respository.ProductRepository;
import com.openclassroom.projet12.respository.SubCatagorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class SubCategorieService {

    private final SubCatagorieRepository subCatagorieRepository;
    private final ProductRepository productRepository;

    public SubCategorie getSubCategorie(Long id) {
        return subCatagorieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(("La sous-catégorie du product n'existe pas"), ErrorCode.SUBCATEGORIE_NOT_FOUND_ERROR));
    }

    public List<SubCategorieDTO> getSubCategories() {
        return subCatagorieRepository.findAll().stream()
                .map(SubCategorieMapper::toDTO)
                .sorted((sc1, sc2) -> (int) (sc1.getId() - sc2.getId()))
                .collect(Collectors.toList());
    }

    public List<SubCategorie> getSubCategoriesByIds(List<Long> ids) {
        return subCatagorieRepository.findAllById(ids);
    }

    public Page<SubCategorieDTO> getSubCategoriesPage(Pageable pageable) {
        return subCatagorieRepository.findAll(pageable)
                .map(SubCategorieMapper::toDTO);
    }

    public SubCategorie addSubCategorie(SubCategorieDTO subCategorieDTO) {
        return subCatagorieRepository.save(SubCategorieMapper.toSousCategorie(subCategorieDTO));
    }

    public SubCategorie updateSubCategorie(SubCategorieDTO subCategorieDTO) {
        SubCategorie subCategorie = getSubCategorie(subCategorieDTO.getId());
        SubCategorieMapper.update(subCategorieDTO, subCategorie);
        return subCatagorieRepository.save(subCategorie);
    }

    public Long deleteSubCategorie(Long id) {
        SubCategorie subCategorie = getSubCategorie(id);
        List<Product> list = productRepository.findAllBySubCategorie(subCategorie);
        if(!list.isEmpty()) {
            throw new NotEmptyException("La sous-catégorie est toujours lié à un produit", ErrorCode.PRODUCT_LINKED_ERROR);
        }
        subCatagorieRepository.deleteById(id);
        return id;
    }
}
