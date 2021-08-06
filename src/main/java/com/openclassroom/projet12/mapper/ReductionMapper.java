package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.ReductionDTO;
import com.openclassroom.projet12.model.Reduction;
import org.springframework.stereotype.Component;

@Component
public class ReductionMapper {

    public static Reduction toReduction(ReductionDTO reductionDTO) {
        return Reduction.builder()
                .id(reductionDTO.getId())
                .percentageReduction(reductionDTO.getPercentageReduction())
                .reductionStart(reductionDTO.getReductionStart())
                .reductionEnd(reductionDTO.getReductionEnd())
                .build();
    }

    public static ReductionDTO toReductionDTO(Reduction reduction) {
        return ReductionDTO.builder()
                .id(reduction.getId())
                .produitID(reduction.getProduct().getId())
                .percentageReduction(reduction.getPercentageReduction())
                .reductionStart(reduction.getReductionStart())
                .reductionEnd(reduction.getReductionEnd())
                .build();
    }

    public static void update(ReductionDTO dto, Reduction entity) {
        entity.setPercentageReduction(dto.getPercentageReduction());
        entity.setReductionStart(dto.getReductionStart());
        entity.setReductionEnd(dto.getReductionEnd());
    }
}
