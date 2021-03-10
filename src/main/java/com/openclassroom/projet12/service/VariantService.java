package com.openclassroom.projet12.service;

import com.openclassroom.projet12.dto.VariantDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.ProduitMapper;
import com.openclassroom.projet12.mapper.VariantMapper;
import com.openclassroom.projet12.model.Produit;
import com.openclassroom.projet12.model.Variant;
import com.openclassroom.projet12.respository.VariantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

import static java.util.stream.Collectors.toList;


@Service
@AllArgsConstructor
public class VariantService {

    private final VariantRepository variantRepository;
    private final ProduitService produitService;


    public List<Variant> getVariants() {
        return variantRepository.findAll();
    }

    public List<VariantDTO> getVariantsByProductId(Long id) {
        return variantRepository.findAllByProduitId(id).stream().map(VariantMapper::toDTO).collect(toList());
    }

    public VariantDTO getVariantDTO(Long id) {
        return VariantMapper.toDTO(variantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Le variant recherché n'a pas été trouvé")));
    }

    public Variant getVariant(Long id) {
        return variantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Le variant recherché n'a pas été trouvé"));
    }

    public Variant addVariant(Long produitID, VariantDTO variantDTO) {
        Produit produit = this.produitService.getProduit(produitID);
        Variant newVariant = VariantMapper.toVariant(variantDTO);
        newVariant.setProduit(produit);
        this.variantRepository.save(newVariant);
        return newVariant;
    }

    public Variant updateVariant(VariantDTO variantDTO) {
        Variant variant = getVariant(variantDTO.getId());
        //todo: reduction?
        VariantMapper.update(variantDTO, variant);
        return variantRepository.save(variant);
    }

    public Long deleteVariant(Long id) {
        variantRepository.deleteById(id);
        return id;
    }
}
