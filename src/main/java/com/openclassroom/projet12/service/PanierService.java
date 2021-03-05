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
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class PanierService {

    private final PanierRepository panierRepository;
    private final PanierLigneRepository panierLigneRepository;


    public Panier getPanier(Long id) {
        return panierRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Le panier n'existe pas !"));
    }

    public Panier addPanier(PanierDTO panierDTO) {
        return panierRepository.save(PanierMapper.toPanier(panierDTO));
    }

    public Panier updatePanier(PanierDTO panierDTO) {
        Panier panier = getPanier(panierDTO.getId());
        //todo: PanierLigne
        PanierMapper.update(panierDTO,panier);
        return panier;
    }

    public Long deletePanier(Long id) {
        panierRepository.deleteById(id);
        return id;
    }

    public List<PanierLigne> getPanierLignes() {
        return panierLigneRepository.findAll();
    }

    public PanierLigne getPanierLigne(Long id) {
        return panierLigneRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("La ligne du panier n'existe pas !"));
    }

    public PanierLigne addPanierLigne(PanierLigneDTO panierLigneDTO) {
        return panierLigneRepository.save(PanierLigneMapper.toPanierLigne(panierLigneDTO));
    }

    public PanierLigne updatePanierLigne(PanierLigneDTO panierLigneDTO) {
        PanierLigne panierLigne = getPanierLigne(panierLigneDTO.getId());
        PanierLigneMapper.update(panierLigneDTO, panierLigne);
        this.panierLigneRepository.save(panierLigne);
        return panierLigne;
    }

    public Long deletePanierLigne(Long id) {
        panierLigneRepository.deleteById(id);
        return id;
    }
}
