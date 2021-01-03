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


import javax.validation.constraints.NotNull;
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

    public Adresse addAdresse(AdresseDTO adresseDTO, String username) {
        User user = userRepository.findByEmail(username);
        if (user != null) {
            Adresse adresse = adresseMapper.adresseDTOtoAdresse(adresseDTO);
            user.getAdresses().add(adresse);
            userRepository.save(user);
        return adresseRepository.save(adresse);
        } else throw new RuntimeException("Une erreure s'est produite lors de la création de l'adresse");
    }

    public Adresse updateAdresse(AdresseDTO adresseDTO, String username) {
        User user = userRepository.findByEmail(username);
        Optional<Adresse> adresseOptional = getAdresse(adresseDTO.getId());
        if(!adresseOptional.isPresent()){
            throw new NotFoundException("L'adresse n'existe pas ou n'a pas été retrouvé");
        }
        if(user != null && user.getAdresses().contains(adresseOptional.get())) {
            adresseOptional.get().setNom(adresseDTO.getNom());
            adresseOptional.get().setNumero(adresseDTO.getNumero());
            adresseOptional.get().setVoie(adresseDTO.getVoie());
            adresseOptional.get().setCodePostal(adresseDTO.getCodePostal());
            adresseOptional.get().setVille(adresseDTO.getVille());
            adresseOptional.get().setBatiment(adresseDTO.getBatiment());
            adresseOptional.get().setDigicode(adresseDTO.getDigicode());
            adresseOptional.get().setInterphone(adresseDTO.getInterphone());
            adresseOptional.get().setEtage(adresseDTO.getEtage());
            adresseOptional.get().setPorte(adresseDTO.getPorte());
           return adresseRepository.save(adresseOptional.get());
        }
        throw new NotFoundException("L'utilisateur ne possède pas l'adress à modifier");
    }

    public Long deleteAdresse(Long id, String username) {
        Optional<Adresse> adresse = getAdresse(id);
        if(adresse.isPresent()) {
            User user = userRepository.findByEmail(username);
            boolean removed = user.getAdresses().remove(adresse.get());
            if(removed) {
                adresseRepository.deleteById(id);
            }
            return id;
        } else throw new NotFoundException("L'adresse n'existe pas ou n'a pas été retrouvé");
    }
}
