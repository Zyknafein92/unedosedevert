package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.TypeDTO;
import com.openclassroom.projet12.model.Type;

import static java.util.stream.Collectors.toList;

public class TypeMapper {

    public static Type toType(TypeDTO typeDTO) {
        return Type.builder()
                .name(typeDTO.getName())
                .build();
    }

    public static TypeDTO toDTO(Type type) {
        return TypeDTO.builder()
                .id(type.getId())
                .name(type.getName())
                .categories(type.getCategories().stream().map(t -> CategorieMapper.toDTO(t)).collect(toList()))
                .build();
    }

    public static void update(TypeDTO dto, Type entity) {
        entity.setName(dto.getName());
    }
}
