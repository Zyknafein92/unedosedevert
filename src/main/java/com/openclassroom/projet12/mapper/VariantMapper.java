package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.VariantDTO;
import com.openclassroom.projet12.model.Variant;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface VariantMapper {


    Variant variantDTOtoVariant(VariantDTO variantDTO);

    VariantDTO variantToVariantDTO(Variant variant);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Variant updateVariantFromVariantDTO(VariantDTO variantDTO, @MappingTarget Variant variant);


}
