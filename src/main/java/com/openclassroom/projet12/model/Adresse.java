package com.openclassroom.projet12.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name= "t_adresse")
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message= "Veuillez définir le genre")
    private String genre;

    @NotNull(message= "Veuillez définir un nom pour votre adresse ! (ex: Travail, Domicile)")
    private String nomAdresse;

    @NotNull(message= "Veuillez définir votre nom !")
    private String nom;

    @NotNull(message= "Veuillez définir votre prénom !")
    private String prenom;

    @NotNull(message= "Veuillez définir un numéro de téléphone")
    private String phone;

    private String digicode;

    @NotNull(message= "Veuillez renseigner le nom ou le numéro de votre interphone !")
    private String interphone;

    @NotNull(message= "Veuillez renseigner votre étage !")
    private Integer etage;

    private String batiment;

    @NotNull(message= "Veuillez renseigner le numéro de voie !")
    private Integer numero;

    @NotNull(message= "Veuillez renseigner le nom de la voie !")
    private String voie;

    @NotNull(message= "Veuillez renseigner votre code postal !")
    private String codePostal;

    @NotNull(message= "Veuillez renseigner le nom de votre ville !")
    private String ville;

    private String information;

    private Boolean livraison;

    private Boolean facturation;
}
