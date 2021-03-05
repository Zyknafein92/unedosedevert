package com.openclassroom.projet12.service;


import com.openclassroom.projet12.dto.CommandeDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.CommandeMapper;
import com.openclassroom.projet12.model.Commande;
import com.openclassroom.projet12.respository.CommandeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class CommandeService {

    private final  CommandeRepository commandeRepository;

    public List<Commande> getCommandes() {
        return commandeRepository.findAll();
    }

    public Commande getCommande(Long id) {
        return commandeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("La commande n'existe pas !"));
    }

//todo:
//    public List<Commande> getCommandesForCurrentUser(String username) {
//        return null;
//    }

    public Commande addCommande(CommandeDTO commandeDTO) {
        return commandeRepository.save(CommandeMapper.toCommande(commandeDTO));
    }

    public Commande updateCommande(CommandeDTO commandeDTO) {
        Commande commande = getCommande(commandeDTO.getId());
        CommandeMapper.update(commandeDTO, commande);
        return commandeRepository.save(commande);
    }

    public Long deleteCommande(Long id) {
        commandeRepository.deleteById(id);
        return id;
    }
}
