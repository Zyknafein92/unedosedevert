package com.openclassroom.projet12.service;

import com.openclassroom.projet12.dto.VariantDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.VariantMapper;
import com.openclassroom.projet12.model.Product;
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
    private final ProductService productService;


    public List<Variant> getVariants() {
        return variantRepository.findAll();
    }

    public List<VariantDTO> getVariantsByProductId(Long id) {
        return variantRepository.findAllByProductId(id).stream().map(VariantMapper::toDTO).collect(toList());
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
        Product product = this.productService.getProduit(produitID);
        Variant newVariant = VariantMapper.toVariant(variantDTO);
        newVariant.setProduct(product);
        product.getVariants().add(newVariant);
        product = this.productService.saveProduit(product);
        return product.getVariants().get(product.getVariants().size() - 1);
    }

    public Variant updateVariant(VariantDTO variantDTO) {
        Variant variant = getVariant(variantDTO.getId());
        VariantMapper.update(variantDTO, variant);
        return variantRepository.save(variant);
    }

    public Long deleteVariant(Long id) {
        variantRepository.deleteById(id);
        return id;
    }
}
