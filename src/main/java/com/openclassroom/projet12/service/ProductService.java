package com.openclassroom.projet12.service;


import com.openclassroom.projet12.dto.*;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.ProductMapper;
import com.openclassroom.projet12.model.*;
import com.openclassroom.projet12.respository.*;
import com.openclassroom.projet12.service.specifications.ProductSpecifications;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final TypeService typeService;
    private final CategorieService categorieService;
    private final SubCategorieService subCategorieService;
    private final ReductionService reductionService;
    private final TagService tagService;
    private final LabelService labelService;
    private final ProductSpecifications specification;

    public List<ProductDTO> getProduits() {
        return productRepository.findAll().stream().map(ProductMapper::toCompleteDTO).collect(toList());
    }

    public Page<ProductDTO> getProduitPage(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(ProductMapper::toCompleteDTO);
    }

    public List<ProductDTO> findProduitsBySpecification(SearchCriteria searchCriteria) {
        if(searchCriteria == null) {
            return productRepository.findAll().stream().map(ProductMapper::toCompleteDTO).collect(toList());
        }
        Specification<Product> categorieSpecification = specification.tagSpecification(searchCriteria.getCategorie());
        Specification<Product> sousCategorieSpecification = specification.sousCategorieSpecification(searchCriteria.getSousCategorie());
        Specification<Product> tagSpecification = specification.tagSpecification(searchCriteria.getTag());
        Specification<Product> querySpecification = specification.querySpecification(searchCriteria.getQuery());
        Specification<Product> totalSpecification = Objects.requireNonNull(categorieSpecification.and(sousCategorieSpecification)).and(tagSpecification).and(querySpecification);
        List<Product> productList = productRepository.findAll(totalSpecification);
        return productList.stream().map(ProductMapper::toCompleteDTO).collect(toList());
    }

    public Product getProduit(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("Le product n'existe pas"));
    }
    public ProductDTO getProduitDTO(Long id) {
        return ProductMapper.toCompleteDTO(productRepository.findById(id).orElseThrow(() -> new NotFoundException("Le product n'existe pas")));
    }

    public Product addProduit(ProductDTO productDTO) {
        Product product = ProductMapper.toProduit(productDTO);
        populateProduit(product, productDTO);
        return productRepository.save(product);
    }

    public Product updateProduit(ProductDTO productDTO) {
        Product product = getProduit(productDTO.getId());
        populateProduit(product, productDTO);
        ProductMapper.update(productDTO, product);
        return productRepository.save(product);
    }

    private Product populateProduit(Product product, ProductDTO productDTO) {
        if( productDTO.getType() != null) {
            Type type = this.typeService.getType(productDTO.getType().getId());
            product.setType(type);
        }
        if( productDTO.getCategorie() != null) {
            Categorie categorie = this.categorieService.getCategorie(productDTO.getCategorie().getId());
            product.setCategorie(categorie);
        }
        if( productDTO.getSubCategorie() != null) {
            SubCategorie subCategorie = this.subCategorieService.getSousCategorie(productDTO.getSubCategorie().getId());
            product.setSubCategorie(subCategorie);
        }
        if( productDTO.getReduction() != null) {
            Reduction reduction = this.reductionService.getReduction(productDTO.getReduction().getId());
            product.setReduction(reduction);
        }
        if( productDTO.getTags() != null) {
            List<Tag> tags = this.tagService.getTagsByIds(productDTO.getTags().stream().map(TagDTO::getId).collect(toList()));
            product.setTags(tags);
        }
        if( productDTO.getLabels() != null) {
            List<Label> labels = this.labelService.getLabelsByIds(productDTO.getLabels().stream().map(LabelDTO::getId).collect(toList()));
            product.setLabels(labels);
        }
        return product;
    }

    public Long deleteProduit(Long id) {
        productRepository.deleteById(id);
        return id;
    }

    public Product saveProduit(Product product) {
        return this.productRepository.save(product);
    }
}
