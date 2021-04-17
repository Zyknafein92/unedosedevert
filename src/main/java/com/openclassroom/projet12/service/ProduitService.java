package com.openclassroom.projet12.service;


import com.openclassroom.projet12.dto.*;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.ProduitMapper;
import com.openclassroom.projet12.model.*;
import com.openclassroom.projet12.respository.*;
import com.openclassroom.projet12.service.specifications.ProduitSpecifications;
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
public class ProduitService {

    private final ProduitRepository produitRepository;
    private final TypeService typeService;
    private final CategorieService categorieService;
    private final SousCategorieService sousCategorieService;
    private final ReductionService reductionService;
    private final TagService tagService;
    private final LabelService labelService;
    private final ProduitSpecifications specification;

    public List<ProduitDTO> getProduits() {
        return produitRepository.findAll().stream().map(ProduitMapper::toDTO).collect(toList());
    }

    public Page<ProduitDTO> getProduitPage(Pageable pageable) {
        return produitRepository.findAll(pageable)
                .map(ProduitMapper::toDTO);
    }

    public List<ProduitDTO> findProduitsBySpecification(SearchCriteria searchCriteria) {
        if(searchCriteria == null) {
            return produitRepository.findAll().stream().map(ProduitMapper::toCompleteDTO).collect(toList());
        }
        Specification<Produit> categorieSpecification = specification.tagSpecification(searchCriteria.getCategorie());
        Specification<Produit> sousCategorieSpecification = specification.sousCategorieSpecification(searchCriteria.getSousCategorie());
        Specification<Produit> tagSpecification = specification.tagSpecification(searchCriteria.getTag());
        Specification<Produit> querySpecification = specification.querySpecification(searchCriteria.getQuery());
        Specification<Produit> totalSpecification = Objects.requireNonNull(categorieSpecification.and(sousCategorieSpecification)).and(tagSpecification).and(querySpecification);
        List<Produit> produitList = produitRepository.findAll(totalSpecification);
        return produitList.stream().map(ProduitMapper::toCompleteDTO).collect(toList());
    }

    public Produit getProduit(Long id) {
        return produitRepository.findById(id).orElseThrow(() -> new NotFoundException("Le produit n'existe pas"));
    }
    public ProduitDTO getProduitDTO(Long id) {
        return ProduitMapper.toCompleteDTO(produitRepository.findById(id).orElseThrow(() -> new NotFoundException("Le produit n'existe pas")));
    }

    public Produit addProduit(ProduitDTO produitDTO) {
        Produit produit = ProduitMapper.toProduit(produitDTO);
        populateProduit(produit, produitDTO);
        return produitRepository.save(produit);
    }

    public Produit updateProduit(ProduitDTO produitDTO) {
        Produit produit = getProduit(produitDTO.getId());
        populateProduit(produit, produitDTO);
        ProduitMapper.update(produitDTO, produit);
        return produitRepository.save(produit);
    }

    private Produit populateProduit(Produit produit, ProduitDTO produitDTO) {
        if( produitDTO.getType() != null) {
            Type type = this.typeService.getType(produitDTO.getType().getId());
            produit.setType(type);
        }
        if( produitDTO.getCategorie() != null) {
            Categorie categorie = this.categorieService.getCategorie(produitDTO.getCategorie().getId());
            produit.setCategorie(categorie);
        }
        if( produitDTO.getSousCategorie() != null) {
            SousCategorie sousCategorie = this.sousCategorieService.getSousCategorie(produitDTO.getSousCategorie().getId());
            produit.setSousCategorie(sousCategorie);
        }
        if( produitDTO.getReduction() != null) {
            Reduction reduction = this.reductionService.getReduction(produitDTO.getReduction().getId());
            produit.setReduction(reduction);
        }
        if( produitDTO.getTags() != null) {
            List<Tag> tags = this.tagService.getTagsByIds(produitDTO.getTags().stream().map(TagDTO::getId).collect(toList()));
            produit.setTags(tags);
        }
        if( produitDTO.getLabels() != null) {
            List<Label> labels = this.labelService.getLabelsByIds(produitDTO.getLabels().stream().map(LabelDTO::getId).collect(toList()));
            produit.setLabels(labels);
        }
        return produit;
    }

    public Long deleteProduit(Long id) {
        produitRepository.deleteById(id);
        return id;
    }

    public Produit saveProduit(Produit produit) {
        return this.produitRepository.save(produit);
    }
}
