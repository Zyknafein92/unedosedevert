package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.ReductionDTO;
import com.openclassroom.projet12.model.Reduction;
import org.springframework.stereotype.Component;

@Component
public class ReductionMapper {

    public static Reduction toReduction(ReductionDTO reductionDTO) {
        return Reduction.builder()
                .reduction(reductionDTO.getReduction())
                .reductionStart(reductionDTO.getReductionStart())
                .reductionEnd(reductionDTO.getReductionEnd())
                .build();
    }

    public static void update(ReductionDTO dto, Reduction entity) {
        entity.setReduction(dto.getReduction());
        entity.setReductionStart(dto.getReductionStart());
        entity.setReductionEnd(dto.getReductionEnd());
    }
}
