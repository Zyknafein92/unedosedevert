package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.LabelDTO;
import com.openclassroom.projet12.model.Label;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LabelMapper {

    Label labelDTOToLabel(LabelDTO labelDTO);

    LabelDTO labelToLabelDTO(Label label);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Label updateLabelFromLabelDTO(LabelDTO tagCategorieDTO, @MappingTarget Label label);


}
