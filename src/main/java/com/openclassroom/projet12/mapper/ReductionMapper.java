package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.ReductionDTO;
import com.openclassroom.projet12.model.Reduction;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ReductionMapper {

    Reduction reductionDTOtoReduction(ReductionDTO reductionDTO);

    ReductionDTO reductionToReductionDTO(Reduction reduc);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Reduction updateReductionFromReductionDTO(ReductionDTO reductionDTO, @MappingTarget Reduction reduction);

}
