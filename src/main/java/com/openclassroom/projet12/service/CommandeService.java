package com.openclassroom.projet12.service;


import com.openclassroom.projet12.dto.*;
import com.openclassroom.projet12.exceptions.NotFoundException;
import com.openclassroom.projet12.mapper.*;
import com.openclassroom.projet12.model.*;
import com.openclassroom.projet12.respository.CommandeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CommandeService {

    private final UserService userService;

    // Une méthode pour retrouver les commandes d'un utilisateur

    private final  CommandeRepository commandeRepository;

    public List<Commande> getCommandes() {
        return commandeRepository.findAll();
    }

    public Commande getCommande(Long id) {
        return commandeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("La commande n'existe pas !"));
    }

    public Commande validerCommande(CommandeDTO commandeDTO, String currentname) {
        List<VariantCommandeDTO> variantCommandeDTOList = new ArrayList<>();
        UserDTO userDTO =  userService.findByEmail(currentname);
        PanierDTO panierDTO = userDTO.getPanier();
        AdresseDTO adresseDTO = commandeDTO.getAdresseDTO();

        for (PanierLigneDTO ligne: userDTO.getPanier().getPanierLignes()) {
            Variant variant =  VariantMapper.toVariant(ligne.getVariant());
            VariantCommandeDTO variantCommandeDTOToSave = VariantCommandeMapper.variantToVariantCommandeDTO(variant);
            variantCommandeDTOToSave.setQuantity(ligne.getQuantity());
            variantCommandeDTOList.add(variantCommandeDTOToSave);
        }
         List<VariantCommande> variantCommandeList = variantCommandeDTOList.stream().map(VariantCommandeMapper::toVariantCommande).collect(Collectors.toList());

        Commande commande = Commande.builder()
                .user(UserMapper.toUser(userDTO))
                .variantCommandeList(variantCommandeList)
                .adresse(AdresseMapper.toAdresse(adresseDTO))
                .statusCommande(StatusCommande.ATTENTE)
                .date(LocalDateTime.now())
                .livraison(commandeDTO.getLivraison())
                .total(variantCommandeList.stream().map(v -> v.calculateTotalPrice()).reduce(0d, (s, v) -> s + v ))
                .build();

        return commandeRepository.save(commande);
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
