package com.openclassroom.projet12.service;

import com.openclassroom.projet12.dto.SubCategorieDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.SubCategorieMapper;
import com.openclassroom.projet12.model.SubCategorie;
import com.openclassroom.projet12.respository.SubCatagorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@AllArgsConstructor
public class SubCategorieService {

    private final SubCatagorieRepository subCatagorieRepository;

    public SubCategorie getSousCategorie(Long id) {
        return subCatagorieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("La sous-catégorie du product n'éxiste pas"));
    }

    public List<SubCategorie> getSousCategories() {
        return subCatagorieRepository.findAll();
    }

    public List<SubCategorie> getSousCategoriesByIds(List<Long> ids) {
        return subCatagorieRepository.findAllById(ids);
    }

    public Page<SubCategorieDTO> getSousContegoriePage(Pageable pageable) {
        return subCatagorieRepository.findAll(pageable)
                .map(SubCategorieMapper::toDTO);
    }

    public SubCategorie addSousCategorie(SubCategorieDTO subCategorieDTO) {
        return subCatagorieRepository.save(SubCategorieMapper.toSousCategorie(subCategorieDTO));
    }

    public SubCategorie updateSousCategorie(SubCategorieDTO subCategorieDTO) {
        SubCategorie subCategorie = getSousCategorie(subCategorieDTO.getId());
        SubCategorieMapper.update(subCategorieDTO, subCategorie);
        return subCatagorieRepository.save(subCategorie);
    }

    public Long deleteSousCategorie(Long id) {
        subCatagorieRepository.deleteById(id);
        return id;
    }
}
