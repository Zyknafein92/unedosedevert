package com.openclassroom.projet12.dto;
import com.openclassroom.projet12.model.ModeReglement;
import com.openclassroom.projet12.model.Panier;
import com.openclassroom.projet12.model.StatusCommande;
import com.openclassroom.projet12.model.User;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
public class CommandeDTO {

    private Long id;

    @NotNull(message="L'utilisateur ne peut pas être null")
    private User user;

    @NotNull(message= "La date ne peut être null")
    private LocalDateTime date;

    @NotNull(message= "Erreur, le prix total doit être affiché")
    private Double total;

    @NotNull(message= "Le status de la commande ne peut être null")
    private StatusCommande statusCommande;

    @NotNull(message= "Veuillez choisir un mode de règlement")
    private ModeReglement modeReglement;

    @NotNull(message= "Un choix de retrait doit être sélectionné")
    private Boolean livraison;

}
