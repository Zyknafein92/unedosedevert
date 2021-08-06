package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.LabelDTO;
import com.openclassroom.projet12.model.Label;
import org.springframework.stereotype.Component;

@Component
public class LabelMapper {

    public static Label toLabel(LabelDTO labelDTO) {
        return Label.builder()
                .name(labelDTO.getName())
                .urlPicture(labelDTO.getUrlPicture())
                .build();
    }

    public static LabelDTO toDTO(Label label) {
        return LabelDTO.builder()
                .id(label.getId())
                .name(label.getName())
                .urlPicture(label.getUrlPicture())
                .build();
    }

    public static void update(LabelDTO dto, Label entity) {
        entity.setName(dto.getName());
        entity.setUrlPicture(dto.getUrlPicture());
    }


}
