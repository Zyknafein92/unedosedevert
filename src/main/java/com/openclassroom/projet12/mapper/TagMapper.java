package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.TagDTO;
import com.openclassroom.projet12.model.Tag;
import org.springframework.stereotype.Component;

@Component
public class TagMapper {

    public static Tag toTag(TagDTO tagDTO) {
        return Tag.builder()
                .name(tagDTO.getName())
                .description(tagDTO.getDescription())
                .build();
    }

    public static TagDTO toDTO(Tag tag) {
        return TagDTO.builder()
                .id(tag.getId())
                .name(tag.getName())
                .description(tag.getDescription())
                .build();
    }

    public static void update(TagDTO dto, Tag entity) {
        entity.setName(dto.getName());
    }
}
