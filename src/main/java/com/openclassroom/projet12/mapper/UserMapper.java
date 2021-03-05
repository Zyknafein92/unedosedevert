package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.UserDTO;
import com.openclassroom.projet12.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static User toUser(UserDTO userDTO) {
        return User.builder()
                .nom(userDTO.getNom())
                .prenom(userDTO.getPrenom())
                .anniversaire(userDTO.getAnniversaire())
                .telephone(userDTO.getTelephone())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .active(userDTO.getActive())
                .build();
    }

    public static void update(UserDTO dto, User entity) {
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setAnniversaire(dto.getAnniversaire());
        entity.setTelephone(dto.getTelephone());
        entity.setEmail(dto.getEmail());
        entity.setPassword(entity.getPassword());
        entity.setActive(entity.getActive());
    }
}


// todo : voir si besoin
//    private List<AdresseDTO> adresses;
//    private PanierDTO panier;
//    private List<CommandeDTO> commandesCommandes;
//    private Set<Role> roles;

