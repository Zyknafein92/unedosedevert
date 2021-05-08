package com.openclassroom.projet12.service;


import com.openclassroom.projet12.dto.AdresseDTO;
import com.openclassroom.projet12.dto.UserDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.AdresseMapper;
import com.openclassroom.projet12.mapper.UserMapper;
import com.openclassroom.projet12.model.Adresse;
import com.openclassroom.projet12.model.User;
import com.openclassroom.projet12.respository.AdresseRepository;
import com.openclassroom.projet12.respository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdresseService {

    private final AdresseRepository adresseRepository;
    private final UserService userService;

    //todo: vérification des droits utilisateurs
    public Adresse getAdresse(Long id) {
        return adresseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("L'adresse n'existe pas !"));
    }

    public Adresse addAdresse(AdresseDTO adresseDTO, String username) {
        boolean gotDelivryAdress = false;
        UserDTO user = userService.findByEmail(username);
        if (user != null) {
            for (AdresseDTO adresse: user.getAdresses())
                if (adresseDTO.getLivraison()) {
                    gotDelivryAdress = true;
                    break;
                }
            if(!gotDelivryAdress) adresseDTO.setLivraison(true);
            Adresse adresse = AdresseMapper.toAdresse(adresseDTO);
            user.getAdresses().add(adresseDTO);
            User userEntity = UserMapper.toUser(user);
            userService.save(userEntity);
            return adresse;
        } else throw new RuntimeException("Une erreure s'est produite lors de la création de l'adresse");
    }

    public Adresse updateAdresse(AdresseDTO adresseDTO, String username) {
        UserDTO user = userService.findByEmail(username);
        Adresse adresse = getAdresse(adresseDTO.getId());
        if(user != null && adresse != null) {
            AdresseMapper.update(adresseDTO, adresse);
            return adresseRepository.save(adresse);
        }
        else throw new RuntimeException("Une erreure s'est produite lors de la modification de l'adresse");
    }

    public Long deleteAdresse(Long id, String username) {
        UserDTO user = userService.findByEmail(username);
        Adresse adresse = getAdresse(id);
        if (adresse != null) {
            user.getAdresses().remove(AdresseMapper.toAdresseDTO(adresse));
            User userEntity = UserMapper.toUser(user);
            userService.save(userEntity);
        } else throw new NotFoundException("L'adresse n'existe pas");
        return id;
    }
}
