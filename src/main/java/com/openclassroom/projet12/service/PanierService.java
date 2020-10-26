package com.openclassroom.projet12.service;


import com.openclassroom.projet12.dto.PanierDTO;
import com.openclassroom.projet12.dto.PanierLigneDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.PanierLigneMapper;
import com.openclassroom.projet12.mapper.PanierMapper;
import com.openclassroom.projet12.model.Panier;
import com.openclassroom.projet12.model.PanierLigne;
import com.openclassroom.projet12.respository.PanierLigneRepository;
import com.openclassroom.projet12.respository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PanierService {

    @Autowired
    PanierRepository panierRepository;

    @Autowired
    PanierMapper panierMapper;

    @Autowired
    PanierLigneRepository panierLigneRepository;

    @Autowired
    PanierLigneMapper panierLigneMapper;

    public Optional<Panier> getPanier(Long id) {
        return panierRepository.findById(id);
    }

    public Panier addPanier(PanierDTO panierDTO) {
        return panierRepository.save(panierMapper.panierDTOtoPanier(panierDTO));
    }

    public Panier updatePanier(PanierDTO panierDTO) {
        Optional<Panier> panierOptional = getPanier(panierDTO.getId());
        Panier panier = null;
        if (panierOptional.isPresent()) {
            panier = Panier.builder()
                    .id(panierOptional.get().getId())
                    .panierLigne(panierOptional.get().getPanierLigne())
                    .prixTotal(panierOptional.get().getPrixTotal())
                    .build();
        }
        if (panier == null) throw new NotFoundException("Le panier n'existe pas ou n'a pas été retrouvé");
        panierMapper.updatePanierFromPanierDTO(panierDTO, panier);
        return panier;
    }

    public Long deletePanier(Long id) {
        panierRepository.deleteById(id);
        return id;
    }

    /*
     *
     *
     *
     */


    public List<PanierLigne> getPanierLignes() {
        return panierLigneRepository.findAll();
    }

    public Optional<PanierLigne> getPanierLigne(Long id) {
        return panierLigneRepository.findById(id);
    }

    public PanierLigne addPanierLigne(PanierLigneDTO panierLigneDTO) {
        return panierLigneRepository.save(panierLigneMapper.panierLigneDTOtoPanierLigne(panierLigneDTO));
    }

    public PanierLigne updatePanierLigne(PanierLigneDTO panierLigneDTO) {
        Optional<PanierLigne> panierLigneOptional = getPanierLigne(panierLigneDTO.getId());
        PanierLigne panierLigne = null;
        if (panierLigneOptional.isPresent()) {
            panierLigne = PanierLigne.builder()
                    .id(panierLigneOptional.get().getId())
                    .produit(panierLigneOptional.get().getProduit())
                    .quantity(panierLigneOptional.get().getQuantity())
                    .prix(panierLigneOptional.get().getPrix())
                    .build();
        }
        if (panierLigne == null) throw new NotFoundException("La ligne du panier n'existe pas ou n'a pas été retrouvé");
        panierLigneMapper.updatePanierLigneFromPanierLigneDTO(panierLigneDTO, panierLigne);
        return panierLigne;
    }

    public Long deletePanierLigne(Long id) {
        panierLigneRepository.deleteById(id);
        return id;
    }
}
