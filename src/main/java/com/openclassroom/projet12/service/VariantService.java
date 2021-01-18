package com.openclassroom.projet12.service;

import com.openclassroom.projet12.dto.VariantDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.VariantMapper;
import com.openclassroom.projet12.model.Variant;
import com.openclassroom.projet12.respository.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VariantService {

    @Autowired
    private VariantRepository variantRepository;

    @Autowired
    private VariantMapper variantMapper;

    public List<Variant> getVariants() {
        return variantRepository.findAll();
    }

    public Optional<Variant> getVariant(Long id) {
        return variantRepository.findById(id);
    }

    public Variant addVariant(VariantDTO variantDTO) {
        return variantRepository.save(variantMapper.variantDTOtoVariant(variantDTO));
    }

    public Variant updateVariant(VariantDTO variantDTO) {
        Optional<Variant> variantOptional = getVariant(variantDTO.getId());
        Variant variant = null;

        if (variantOptional.isPresent()) {
            variant = Variant.builder()
                    .id(variantOptional.get().getId())
                    .prix(variantOptional.get().getPrix())
                    .tva(variantOptional.get().getTva())
                    .reduction(variantOptional.get().getReduction())
                    .stock(variantOptional.get().getStock())
                    .imageURL(variantOptional.get().getImageURL())
                    .build();
        }
        if (variant == null) throw new NotFoundException("Le variant recherché n'a pas été trouvé");
        variantMapper.updateVariantFromVariantDTO(variantDTO, variant);
        return variantRepository.save(variant);
    }

    public Long deleteVariant(Long id) {
        variantRepository.deleteById(id);
        return id;
    }
}
