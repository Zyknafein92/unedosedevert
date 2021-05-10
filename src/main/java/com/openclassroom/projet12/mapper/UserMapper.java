package com.openclassroom.projet12.mapper;

import com.openclassroom.projet12.dto.AdresseDTO;
import com.openclassroom.projet12.dto.UserDTO;
import com.openclassroom.projet12.model.Adresse;
import com.openclassroom.projet12.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public static User toUser(UserDTO userDTO) {
        List<Adresse> adresseList = userDTO.getAdresses().stream().map(AdresseMapper::toAdresse).collect(Collectors.toList());

        return User.builder()
                .id(userDTO.getId())
                .adresses(adresseList)
                .genre(userDTO.getGenre())
                .nom(userDTO.getNom())
                .prenom(userDTO.getPrenom())
                .anniversaire(userDTO.getAnniversaire())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .active(userDTO.getActive())
                .newsletter(userDTO.getNewsletter())
                .build();
    }

    public static UserDTO toUserDTO(User user) {
        List<AdresseDTO> adresseDTOList = user.getAdresses().stream().map(AdresseMapper::toAdresseDTO).collect(Collectors.toList());
        return UserDTO.builder()
                .id(user.getId())
                .adresses(adresseDTOList)
                .genre(user.getGenre())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .anniversaire(user.getAnniversaire())
                .email(user.getEmail())
                .password(user.getPassword())
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


