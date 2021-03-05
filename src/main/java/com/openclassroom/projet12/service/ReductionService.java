package com.openclassroom.projet12.service;

import com.openclassroom.projet12.dto.ReductionDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.ReductionMapper;
import com.openclassroom.projet12.model.Reduction;
import com.openclassroom.projet12.respository.ReductionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReductionService {

    private final ReductionRepository reductionRepository;

    public List<Reduction> getReductions() {
        return reductionRepository.findAll();
    }

    public Reduction getReduction(Long id) {
        return reductionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Le reduction recherché n'a pas été trouvé"));
    }

    public Reduction addReduction(ReductionDTO reductionDTO) {
        return reductionRepository.save(ReductionMapper.toReduction(reductionDTO));
    }

    public Reduction updateReduction(ReductionDTO reductionDTO) {
        Reduction reduction = getReduction(reductionDTO.getId());
        ReductionMapper.update(reductionDTO, reduction);
        return reductionRepository.save(reduction);
    }

    public Long deleteReduction(Long id) {
        reductionRepository.deleteById(id);
        return id;
    }
}
