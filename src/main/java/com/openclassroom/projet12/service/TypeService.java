package com.openclassroom.projet12.service;

import com.openclassroom.projet12.dto.TypeDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.TypeMapper;
import com.openclassroom.projet12.model.Type;
import com.openclassroom.projet12.respository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private TypeMapper typeMapper;

    public List<Type> getTypes() {
        return typeRepository.findAll();
    }

    public Optional<Type> getType(Long id) {
        return typeRepository.findById(id);
    }

    public Type addType(TypeDTO typeDTO) {
        return typeRepository.save(typeMapper.typeDTOtoType(typeDTO));
    }

    public Type updateType(TypeDTO typeDTO) {
        Optional<Type> typeOptional = getType(typeDTO.getId());
        Type type = null;

        if(typeOptional.isPresent()) {
            type = Type.builder()
                    .id(typeOptional.get().getId())
                    .name(typeOptional.get().getName())
                    .categories(typeOptional.get().getCategories())
                    .build();
        }
        if(type == null) throw new NotFoundException("La type n'existe pas !");
        typeRepository.save(typeMapper.updateTypeFromTypeDTO(typeDTO,type));
        return type;
    }

    public Long deleteType(Long id) {
        typeRepository.deleteById(id);
        return id;
    }
}
