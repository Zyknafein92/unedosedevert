package com.openclassroom.projet12.service;


import com.openclassroom.projet12.dto.*;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.ProduitMapper;
import com.openclassroom.projet12.model.*;
import com.openclassroom.projet12.respository.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    private final VariantService variantService;

    public List<Produit> getProduits() {
        return produitRepository.findAll();
    }

    public Page<ProduitDTO> getProduitPage(Pageable pageable) {
        return produitRepository.findAll(pageable)
                .map(ProduitMapper::toDTO);
    }

    public List<Produit> findProduitsByCriteria(SearchCriteria searchCriteria) {
        List<Produit> produits = null;
        Type type = searchCriteria.getType();
        Categorie categorie = searchCriteria.getCategorie();
        if(type != null && categorie != null) {
            produits = produitRepository.findAllByCategorieAndType(searchCriteria.getCategorie(), searchCriteria.getType());
        } else if(categorie != null) {
            produits = produitRepository.findAllByCategorie(searchCriteria.getCategorie());
        } else if(type != null) {
            produits = produitRepository.findAllByType(searchCriteria.getType());
        }
        return produits;
    }

    public Produit getProduit(Long id) {
        return produitRepository.findById(id).orElseThrow(() -> new NotFoundException("Le produit n'existe pas"));
    }

    public Produit addProduit(ProduitDTO produitDTO) {

        Type type = this.typeService.getType(produitDTO.getId());
        Categorie categorie = this.categorieService.getCategorie(produitDTO.getCategorie().getId());
        SousCategorie sousCategorie = this.sousCategorieService.getSousCategorie(produitDTO.getSousCategorie().getId());
        Reduction reduction = this.reductionService.getReduction(produitDTO.getReduction().getId());
        List<Tag> tags = this.tagService.getTagsByIds(produitDTO.getTags().stream().map(TagDTO::getId).collect(toList()));
        List<Label> labels = this.labelService.getLabelsByIds(produitDTO.getLabels().stream().map(LabelDTO::getId).collect(toList()));
        List<Variant> variants = this.variantService.getVariantsByIds(produitDTO.getVariants().stream().map(VariantDTO::getId).collect(toList()));

        Produit produit = Produit.builder()
                .type(type)
                .categorie(categorie)
                .sousCategorie(sousCategorie)
                .reduction(reduction)
                .tags(tags)
                .labels(labels)
                .variants(variants)
                .build();

        ProduitMapper.toProduit(produitDTO);
        return produitRepository.save(produit);
    }


    public Produit updateProduit(ProduitDTO produitDTO) {
        Produit produit = getProduit(produitDTO.getId());

        Type type = this.typeService.getType(produitDTO.getId());
        Categorie categorie = this.categorieService.getCategorie(produitDTO.getCategorie().getId());
        SousCategorie sousCategorie = this.sousCategorieService.getSousCategorie(produitDTO.getSousCategorie().getId());
        Reduction reduction = this.reductionService.getReduction(produitDTO.getReduction().getId());
        List<Tag> tags = this.tagService.getTagsByIds(produitDTO.getTags().stream().map(TagDTO::getId).collect(toList()));
        List<Label> labels = this.labelService.getLabelsByIds(produitDTO.getLabels().stream().map(LabelDTO::getId).collect(toList()));
        List<Variant> variants = this.variantService.getVariantsByIds(produitDTO.getVariants().stream().map(VariantDTO::getId).collect(toList()));

        produit.setType(type);
        produit.setCategorie(categorie);
        produit.setSousCategorie(sousCategorie);
        produit.setReduction(reduction);
        produit.setTags(tags);
        produit.setLabels(labels);
        produit.setVariants(variants);
        ProduitMapper.update(produitDTO, produit);

        return produitRepository.save(produit);
    }

    public Long deleteProduit(Long id) {
        produitRepository.deleteById(id);
        return id;
    }
}
