package com.openclassroom.projet12.service;

import com.openclassroom.projet12.dto.CategorieDTO;
import com.openclassroom.projet12.dto.TypeDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.TypeMapper;
import com.openclassroom.projet12.model.Categorie;
import com.openclassroom.projet12.model.Type;
import com.openclassroom.projet12.respository.TypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;


import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class TypeService {

    private final TypeRepository typeRepository;
    private final CategorieService categorieService;

    public List<Type> getTypes() {
        return typeRepository.findAll().stream().sorted((t1, t2) -> (int) (t1.getId() - t2.getId())).collect(toList());
    }

    public Type getType(Long id) {
        return typeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Le type n'existe pas"));
    }

    public Page<TypeDTO> getTypePage(Pageable pageable) {
        return typeRepository.findAll(pageable)
                .map(TypeMapper::toDTO);
    }

    public Type addType(TypeDTO typeDTO) {
        List<Categorie> categories = categorieService.getCategoriesByIds(typeDTO.getCategories().stream().map(CategorieDTO::getId).collect(toList()));
        Type type = TypeMapper.toType(typeDTO);
        type.setCategories(categories);
        return typeRepository.save(type);
    }

    public Type updateType(TypeDTO typeDTO) {
        Type type = getType(typeDTO.getId());
        List<Categorie> categories = categorieService.getCategoriesByIds(typeDTO.getCategories().stream().map(CategorieDTO::getId).collect(toList()));
        type.setCategories(categories);
        TypeMapper.update(typeDTO,type);
        return typeRepository.save(type);
    }

    public Long deleteType(Long id) {
        typeRepository.deleteById(id);
        return id;
    }
}
