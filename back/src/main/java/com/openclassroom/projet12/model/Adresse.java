package com.openclassroom.projet12.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull(message= "Veuillez définir un nom pour votre adresse ! (ex: Travail, Domicile)")
    private String nom;

    @NotNull(message= "Veuillez renseigner le numéro de voie !")
    private Integer numero;

    @NotNull(message= "Veuillez renseigner le nom de la voie !")
    private String voie;

    @NotNull(message= "Veuillez renseigner votre code postal !")
    private String codePostal;

    @NotNull(message= "Veuillez renseigner le nom de votre ville !")
    private String ville;

    private String batiment;

    private String digicode;

    @NotNull(message= "Veuillez renseigner le nom ou le numéro de votre interphone !")
    private String interphone;

    @NotNull(message= "Veuillez renseigner votre étage !")
    private Integer etage;

    @NotNull(message= "Veuillez renseigner votre porte sur le palier !")
    private String porte;


}
