package com.openclassroom.projet12.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name= "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Adresse> adresses;

    @OneToOne
    private Panier panier;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
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
    @Column(unique = true)
    private String email;

    @NotNull(message = "Veuillez renseigner un mot de passe !")
    private String password;

    // pour pouvoir désactiver un compte si besoin
    private Boolean active;

}