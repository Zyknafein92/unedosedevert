package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.TagsCategorieDTO;
import com.openclassroom.projet12.model.TagsCategorie;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TagsCategorieMapper {

    TagsCategorie tagCategorieDTOtoTagsCategorie(TagsCategorieDTO tagsCategorieDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    TagsCategorie updateTagsCategorieFromTagsCategorieDTO(TagsCategorieDTO tagCategorieDTO, @MappingTarget TagsCategorie tagsCategorie);
}
