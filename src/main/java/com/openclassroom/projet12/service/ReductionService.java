package com.openclassroom.projet12.service;

import com.openclassroom.projet12.dto.ReductionDTO;
import com.openclassroom.projet12.dto.SearchCriteria;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.ReductionMapper;
import com.openclassroom.projet12.model.Categorie;
import com.openclassroom.projet12.model.Reduction;
import com.openclassroom.projet12.model.Type;
import com.openclassroom.projet12.respository.ReductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReductionService {

    @Autowired
    private ReductionRepository reductionRepository;

    @Autowired
    private ReductionMapper reductionMapper;

    public List<Reduction> getReductions() {
        return reductionRepository.findAll();
    }

    public Optional<Reduction> getReduction(Long id) {
        return reductionRepository.findById(id);
    }

    public Reduction addReduction(ReductionDTO reductionDTO) {
        return reductionRepository.save(reductionMapper.reductionDTOtoReduction(reductionDTO));
    }

    public Reduction updateReduction(ReductionDTO reductionDTO) {
        Optional<Reduction> reductionOptional = getReduction(reductionDTO.getId());
        Reduction reduction = null;

        if (reductionOptional.isPresent()) {
            reduction = Reduction.builder()
                    .id(reductionOptional.get().getId())

                    .reductionStart(reductionOptional.get().getReductionStart())
                    .reductionEnd(reductionOptional.get().getReductionEnd())
                    .build();
        }
        if (reduction == null) throw new NotFoundException("Le reduction recherché n'a pas été trouvé");
        reductionMapper.updateReductionFromReductionDTO(reductionDTO, reduction);
        return reductionRepository.save(reduction);
    }

    public Long deleteReduction(Long id) {
        reductionRepository.deleteById(id);
        return id;
    }
}
