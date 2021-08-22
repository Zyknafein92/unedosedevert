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
    private final ProductSpecifications productSpecifications;

    public List<ProductDTO> getProduits() {
        return productRepository.findAll().stream().map(ProductMapper::toCompleteDTO).collect(toList());
    }

    public Page<ProductDTO> getProduitPage(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(ProductMapper::toCompleteDTO);
    }

    public List<ProductDTO> findProduitsBySpecification(SearchCriteria searchCriteria) {
        Specification<Product> specification = Specification.where(null);
        if(searchCriteria.getCategorie() != null) {
            Specification<Product> categorieSpecification = productSpecifications.categorieSpecification(searchCriteria.getCategorie());
            specification = specification.and(categorieSpecification);
        }

        if(searchCriteria.getSubCategorie() != null) {
            Specification<Product> subCategorieSpecification = productSpecifications.subCategorieSpecification(searchCriteria.getSubCategorie());
            specification = specification.and(subCategorieSpecification);
        }

        if(searchCriteria.getTag() != null) {
            Specification<Product> tagSpecification = productSpecifications.tagSpecification(searchCriteria.getTag());
            specification = specification.and(tagSpecification);
        }

        if(searchCriteria.getLabel() != null) {
            Specification<Product> labelSpecification = productSpecifications.labelSpecification(searchCriteria.getLabel());
            specification = specification.and(labelSpecification);
        }

        if(searchCriteria.isReduction()) {
            Specification<Product> reductionSpecification = productSpecifications.reductionSpecification();
            specification = specification.and(reductionSpecification);
        }

        if(searchCriteria.getQuery() != null) {
            Specification<Product> searchSpecification = productSpecifications.querySpecification(searchCriteria.getQuery());
           return productRepository.findAll(searchSpecification).stream().map(ProductMapper::toCompleteDTO).collect(toList());
        }
        return productRepository.findAll(specification).stream().map(ProductMapper::toCompleteDTO).collect(toList());
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

    public ProductDTO updateProduit(ProductDTO productDTO) {
        Product product = getProduit(productDTO.getId());
        populateProduit(product, productDTO);
        ProductMapper.update(productDTO, product);
        productRepository.save(product);
        ProductDTO productDTOToSend = ProductMapper.toCompleteDTO(product);
        return productDTOToSend;
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
            SubCategorie subCategorie = this.subCategorieService.getSubCategorie(productDTO.getSubCategorie().getId());
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
