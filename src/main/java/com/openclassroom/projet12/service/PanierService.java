package com.openclassroom.projet12.service;


import com.openclassroom.projet12.dto.PanierDTO;
import com.openclassroom.projet12.dto.PanierLigneDTO;
import com.openclassroom.projet12.dto.UserDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.*;
import com.openclassroom.projet12.model.Panier;
import com.openclassroom.projet12.model.PanierLigne;
import com.openclassroom.projet12.model.User;
import com.openclassroom.projet12.respository.PanierLigneRepository;
import com.openclassroom.projet12.respository.PanierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class PanierService {

    private final PanierRepository panierRepository;
    private final PanierLigneRepository panierLigneRepository;
    private final UserService userService;


    public PanierDTO getPanier(String currentUsername) {
        UserDTO userDTO = userService.findByEmail(currentUsername);
        if (userDTO != null) {
            return userDTO.getPanier();
        } else throw new NotFoundException("Le panier n'existe pas !");
    }

    public Panier addToPanier(List<PanierLigneDTO> panierLigneDTOList, String currentUsername) {
        UserDTO userDTO = userService.findByEmail(currentUsername);
        if (userDTO != null) {
            // creer panier dto
            // convertir vers panier
            for (PanierLigneDTO panierLigneDTO: panierLigneDTOList) {
                userDTO.getPanier().getPanierLignes().add(panierLigneDTO);
            }
            // calcul prix total
            userDTO.getPanier().setPrixTotal(panierLigneDTOList.stream().mapToDouble(PanierLigneDTO::getPrix).reduce(Double::sum).getAsDouble());
            Panier panier = PanierMapper.toPanier(userDTO.getPanier());
            return panierRepository.save(panier);
        }
       else throw new RuntimeException("Une erreur s'est produite");
    }
//
//    public Panier updatePanier(PanierDTO panierDTO, String currentUsername) {
//        UserDTO userDTO = userService.findByEmail(currentUsername);
//        Panier panier = UserMapper.toUser(userDTO).getPanier();
//        PanierMapper.update(panierDTO,panier);
//        return panier;
//    }


    // PanierLigne //

//    public List<PanierLigne> getPanierLignes() {
//        return panierLigneRepository.findAll();
//    }

    public PanierLigne getPanierLigne(Long id) {
        return panierLigneRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("La ligne du panier n'existe pas !"));
    }

    public PanierLigne addPanierLigne(PanierLigneDTO panierLigneDTO, String currentUsername) {
        UserDTO userDTO = userService.findByEmail(currentUsername);
        if (userDTO != null) {
            PanierLigne panierLigne = PanierLigneMapper.toPanierLigne(panierLigneDTO);
            userDTO.getPanier().getPanierLignes().add(panierLigneDTO);
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
            panierLigne.setProduit(ProduitMapper.toProduit(panierLigneDTO.getProduit()));
            panierLigne.setVariant(VariantMapper.toVariant(panierLigneDTO.getVariant()));
            this.panierLigneRepository.save(panierLigne);
            return panierLigne;
        }
        else throw new RuntimeException("Une erreure s'est produite lors de la modification de la ligne du panier");
    }

    public Long deletePanierLigne(String currentUsername, Long id) {
        UserDTO userDTO = userService.findByEmail(currentUsername);
        PanierLigne panierLigne = getPanierLigne(id);
        if (userDTO != null && panierLigne != null) {
            userDTO.getPanier().getPanierLignes().remove(PanierLigneMapper.toPanierLigneDTO(panierLigne));
            userService.save(UserMapper.toUser(userDTO));
            return id;
        } else throw new NotFoundException("La ligne n'existe pas");
    }
}
