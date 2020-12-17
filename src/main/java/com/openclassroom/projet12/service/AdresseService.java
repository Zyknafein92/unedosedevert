package com.openclassroom.projet12.service;


import com.openclassroom.projet12.dto.AdresseDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.AdresseMapper;
import com.openclassroom.projet12.model.Adresse;
import com.openclassroom.projet12.model.User;
import com.openclassroom.projet12.respository.AdresseRepository;
import com.openclassroom.projet12.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class AdresseService {

    @Autowired
    AdresseRepository adresseRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    AdresseMapper adresseMapper;

    public Optional<Adresse> getAdresse(Long id) {
        return adresseRepository.findById(id);
    }

    public Adresse addAdresse(AdresseDTO adresseDTO) {
        User user = userRepository.getOne(adresseDTO.getUserID());

        if(user.getId() != null) {
            Adresse adresse = adresseMapper.adresseDTOtoAdresse(adresseDTO);
            user.getAdresses().add(adresse);
            userRepository.save(user);
        return adresseRepository.save(adresse);
        } else throw new RuntimeException("Une erreure s'est produite lors de la création de l'adresse");
    }

    public Adresse updateAdresse(AdresseDTO adresseDTO) {
        Optional<Adresse> adresseOptional = getAdresse(adresseDTO.getId());
        Adresse adresse = null;
        if(adresseOptional.isPresent()) {
            adresse = Adresse.builder()
                    .nom(adresseOptional.get().getNom())
                    .numero(adresseOptional.get().getNumero())
                    .voie(adresseOptional.get().getVoie())
                    .codePostal(adresseOptional.get().getCodePostal())
                    .ville(adresseOptional.get().getVille())
                    .batiment(adresseOptional.get().getBatiment())
                    .digicode(adresseOptional.get().getDigicode())
                    .interphone(adresseOptional.get().getInterphone())
                    .etage(adresseOptional.get().getEtage())
                    .porte(adresseOptional.get().getPorte())
                    .build();
        }
        if(adresse == null) throw new NotFoundException("L'adresse n'existe pas ou n'a pas été retrouvé");
        adresseMapper.updateAdresseFromAdresseDTO(adresseDTO,adresse);
        return adresse;
    }

    public Long deleteAdresse(Long id) {
        Optional<Adresse> adresse = getAdresse(id);
        if(adresse.isPresent()) {
            User user = userRepository.getOne(adresse.get().getUserID());
            user.getAdresses().remove(adresse.get());
            adresseRepository.deleteById(id);
            return id;
        } else throw new NotFoundException("L'adresse n'existe pas ou n'a pas été retrouvé");
    }
}
