package com.openclassroom.projet12.service;


import com.openclassroom.projet12.dto.ProduitDTO;
import com.openclassroom.projet12.dto.SearchCriteria;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.ProduitMapper;
import com.openclassroom.projet12.model.Categorie;
import com.openclassroom.projet12.model.Produit;
import com.openclassroom.projet12.model.Type;
import com.openclassroom.projet12.respository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    
    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private ProduitMapper produitMapper;
    
    public List<Produit> getProduits() {
        return produitRepository.findAll();
    }

    public Page<ProduitDTO> getProduitPage(Pageable pageable) {
        return produitRepository.findAll(pageable)
                .map(prod -> produitMapper.produitToProduitDTO(prod));
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

    public Optional<Produit> getProduit(Long id) {
        return produitRepository.findById(id);
    }

    public Produit addProduit(ProduitDTO produitDTO) {
        return produitRepository.save(produitMapper.produitDTOtoProduit(produitDTO));
    }

    public Produit updateProduit(ProduitDTO produitDTO) {
        Optional<Produit> produitOptional = getProduit(produitDTO.getId());
        Produit produit = null;

        if(produitOptional.isPresent()) {
            produit = Produit.builder()
                    .id(produitOptional.get().getId())
                    .name(produitOptional.get().getName())
                    .categorie(produitOptional.get().getCategorie())
                    .type(produitOptional.get().getType())
                    .description(produitOptional.get().getDescription())
                    .origine(produitOptional.get().getOrigine())
                    .prix(produitOptional.get().getPrix())
                    .tva(produitOptional.get().getTva())
                    .stock(produitOptional.get().getStock())
                    .urlPhotoPetite(produitOptional.get().getUrlPhotoPetite())
                    .urlPhotoGrande(produitOptional.get().getUrlPhotoGrande())
                    .build();
        }

        if(produit == null) throw new NotFoundException("Le produit recherché n'a pas été trouvé");
        produitMapper.updateProduitFromProduitDTO(produitDTO, produit);
        return produitRepository.save(produit);
    }

    public Long deleteProduit(Long id) {
        produitRepository.deleteById(id);
        return id;
    }
}
