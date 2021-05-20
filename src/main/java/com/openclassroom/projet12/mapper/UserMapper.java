package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.AdresseDTO;
import com.openclassroom.projet12.dto.PanierDTO;
import com.openclassroom.projet12.dto.PanierLigneDTO;
import com.openclassroom.projet12.dto.UserDTO;
import com.openclassroom.projet12.model.Adresse;
import com.openclassroom.projet12.model.Panier;
import com.openclassroom.projet12.model.PanierLigne;
import com.openclassroom.projet12.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public static User toUser(UserDTO userDTO) {

        List<Adresse> adresseList = userDTO.getAdresses() == null ? new ArrayList<>() : userDTO.getAdresses().stream().map(AdresseMapper::toAdresse).collect(Collectors.toList());
        List<PanierLigne> panierLigneList = userDTO.getPanierDTO().getPanierLigneDTOList() == null ? new ArrayList<>() : userDTO.getPanierDTO().getPanierLigneDTOList().stream().map(PanierLigneMapper::toPanierLigne).collect(Collectors.toList());

        Panier panier = Panier.builder()
                .id(userDTO.getPanierDTO().getId())
                .panierLigne(panierLigneList)
                .prixTotal(userDTO.getPanierDTO().getPrixTotal())
                .build();

        return User.builder()
                .id(userDTO.getId())
                .adresses(adresseList)
                .genre(userDTO.getGenre())
                .nom(userDTO.getNom())
                .prenom(userDTO.getPrenom())
                .anniversaire(userDTO.getAnniversaire())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .panier(panier)
                .active(userDTO.getActive())
                .newsletter(userDTO.getNewsletter())
                .build();
    }

    public static UserDTO toUserDTO(User user) {
        List<AdresseDTO> adresseDTOList = user.getAdresses().stream().map(AdresseMapper::toAdresseDTO).collect(Collectors.toList());
        List<PanierLigneDTO> panierLigneList = user.getPanier().getPanierLigne() == null ? new ArrayList<>() : user.getPanier().getPanierLigne().stream().map(PanierLigneMapper::toPanierLigneDTO).collect(Collectors.toList());

        PanierDTO panierDTO = PanierDTO.builder()
                .id(user.getPanier().getId())
                .panierLigneDTOList(panierLigneList)
                .prixTotal(user.getPanier().getPrixTotal())
                .build();

        return UserDTO.builder()
                .id(user.getId())
                .adresses(adresseDTOList)
                .genre(user.getGenre())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .anniversaire(user.getAnniversaire())
                .email(user.getEmail())
                .password(user.getPassword())
                .panierDTO(panierDTO)
                .active(user.getActive())
                .newsletter(user.getNewsletter())
                .build();
    }

    public static void update(UserDTO dto, User entity) {
        entity.setGenre(dto.getGenre());
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setAnniversaire(dto.getAnniversaire());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setActive(dto.getActive());
        entity.setNewsletter(dto.getNewsletter());
    }
}


