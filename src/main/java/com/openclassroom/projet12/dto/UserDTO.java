package com.openclassroom.projet12.dto;


import com.openclassroom.projet12.model.Adresse;
import com.openclassroom.projet12.model.Commande;
import com.openclassroom.projet12.model.Panier;
import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class UserDTO {

    private Long id;

    private List<Adresse> adresses;

    private Panier panier;

    private List<Commande> commandes;

    @NotNull(message= "Veuillez renseigner votre nom !")
    private String nom;

    @NotNull(message= "Veuillez renseigner votre prénom !")
    private String prenom;

    @NotNull(message= "Veuillez renseigner une date de naissance !")
    private LocalDate anniversaire;

    @NotNull(message= "Veuillez renseigner un numéro de téléphone !")
    private String telephone;

    @NotNull(message= "Veuillez renseigner un email !")
    private String email;

    @NotNull(message = "Veuillez renseigner un mot de passe !")
    private String password;

    private Boolean active;
}
