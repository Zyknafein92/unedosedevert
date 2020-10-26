package com.openclassroom.projet12.service;


import com.openclassroom.projet12.dto.CommandeDTO;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.CommandeMapper;
import com.openclassroom.projet12.model.Commande;
import com.openclassroom.projet12.respository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CommandeService {

    @Autowired
    CommandeRepository commandeRepository;

    @Autowired
    CommandeMapper commandeMapper;


    public List<Commande> getCommandes() {
        return commandeRepository.findAll();
    }

    public Optional<Commande> getCommande(Long id) {
        return commandeRepository.findById(id);
    }

    public Commande addCommande(CommandeDTO commandeDTO) {
        return commandeRepository.save(commandeMapper.commandeDTOtoCommande(commandeDTO));
    }

    public Commande updateCommande(CommandeDTO commandeDTO) {
        Optional<Commande> commandeOptional = getCommande(commandeDTO.getId());
        Commande commande = null;

        if(commandeOptional.isPresent()) {
            commande = Commande.builder()
                    .id(commandeOptional.get().getId())
                    .date(commandeOptional.get().getDate())
                    .total(commandeOptional.get().getTotal())
                    .statusCommande(commandeOptional.get().getStatusCommande())
                    .modeReglement(commandeOptional.get().getModeReglement())
                    .livraison(commandeOptional.get().getLivraison())
                    .build();
        }
        if(commande == null) throw new NotFoundException("La commande n'existe pas !");
        commandeRepository.save(commandeMapper.updateCommandeFromCommandeDTO(commandeDTO,commande));
        return commande;
    }

    public Long deleteCommande(Long id) {
        commandeRepository.deleteById(id);
        return id;
    }
}
