package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.TagDTO;
import com.openclassroom.projet12.model.Tag;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TagMapper {

    Tag tagDTOtoTag(TagDTO tagDTO);

    TagDTO tagToTagDTO(Tag tag);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Tag updateTagFromTagDTO(TagDTO tagDTO, @MappingTarget Tag tag);
}
