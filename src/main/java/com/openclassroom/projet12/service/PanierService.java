package com.openclassroom.projet12.service;


import com.openclassroom.projet12.dto.PanierDTO;
import com.openclassroom.projet12.dto.PanierLigneDTO;
import com.openclassroom.projet12.dto.UserDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.PanierLigneMapper;
import com.openclassroom.projet12.mapper.PanierMapper;
import com.openclassroom.projet12.mapper.UserMapper;
import com.openclassroom.projet12.model.Panier;
import com.openclassroom.projet12.model.PanierLigne;
import com.openclassroom.projet12.model.User;
import com.openclassroom.projet12.respository.PanierLigneRepository;
import com.openclassroom.projet12.respository.PanierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class PanierService {

    private final PanierRepository panierRepository;
    private final PanierLigneRepository panierLigneRepository;
    private final UserService userService;


    public PanierDTO getPanier(String currentUsername) {
        UserDTO userDTO = userService.findByEmail(currentUsername);
        if (userDTO != null) {
            return userDTO.getPanierDTO();
        } else throw new NotFoundException("Le panier n'existe pas !");
    }

    public Panier addPanier(PanierDTO panierDTO, String currentUsername) {
        UserDTO userDTO = userService.findByEmail(currentUsername);
        if (userDTO != null) {
            userDTO.setPanierDTO(panierDTO);
            User entityToSave = UserMapper.toUser(userDTO);
            userService.save(entityToSave);
        }
        return panierRepository.save(PanierMapper.toPanier(panierDTO));
    }

    public Panier updatePanier(PanierDTO panierDTO, String currentUsername) {
        UserDTO userDTO = userService.findByEmail(currentUsername);
        Panier panier = UserMapper.toUser(userDTO).getPanier();
        PanierMapper.update(panierDTO,panier);
        return panier;
    }

    public Long deletePanier(Long id) {
        panierRepository.deleteById(id);
        return id;
    }

    // PanierLigne //

    public List<PanierLigne> getPanierLignes() {
        return panierLigneRepository.findAll();
    }

    public PanierLigne getPanierLigne(Long id) {
        return panierLigneRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("La ligne du panier n'existe pas !"));
    }

    public PanierLigne addPanierLigne(PanierLigneDTO panierLigneDTO, String currentUsername) {
        UserDTO userDTO = userService.findByEmail(currentUsername);
        if (userDTO != null) {
            PanierLigne panierLigne = PanierLigneMapper.toPanierLigne(panierLigneDTO);
            userDTO.getPanierDTO().getPanierLigneDTOList().add(panierLigneDTO);
            User entityToSave = UserMapper.toUser(userDTO);
            userService.save(entityToSave);
            return panierLigne;
        } else throw new RuntimeException("Une erreure s'est produite lors de la création de la ligne du panier");
    }

    public PanierLigne updatePanierLigne(PanierLigneDTO panierLigneDTO, String currentUsername) {
        UserDTO userDTO = userService.findByEmail(currentUsername);
        PanierLigne panierLigne = getPanierLigne(panierLigneDTO.getId());
        if (userDTO != null && panierLigne != null) {
            PanierLigneMapper.update(panierLigneDTO, panierLigne);
            this.panierLigneRepository.save(panierLigne);
            return panierLigne;
        }
        else throw new RuntimeException("Une erreure s'est produite lors de la modification de la ligne du panier");
    }

    public Long deletePanierLigne(Long id) {
        panierLigneRepository.deleteById(id);
        return id;
    }
}
