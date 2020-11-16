package com.openclassroom.projet12.mapper;


import com.openclassroom.projet12.dto.TypeDTO;
import com.openclassroom.projet12.model.Type;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TypeMapper {

    Type typeDTOtoType(TypeDTO typeDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Type updateTypeFromTypeDTO(TypeDTO typeDTO, @MappingTarget Type type);
}
