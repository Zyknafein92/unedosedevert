package com.openclassroom.projet12.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class AdressDTO {

    private Long id;

    @NotNull(message= "Veuillez définir le genre")
    private String gender;

    @NotNull(message= "Veuillez définir un nom pour votre adresse ! (ex: Travail, Domicile)")
    private String adressName;

    @NotNull(message= "Veuillez définir votre nom !")
    private String lastName;

    @NotNull(message= "Veuillez définir votre prénom !")
    private String firstName;

    @NotNull(message= "Veuillez définir un numéro de téléphone")
    private String phone;

    private String digicode;

    private String interphone;

    private String appartNumber;

    @NotNull(message= "Veuillez renseigner votre étage !")
    private Integer floor;

    private String building;

    @NotNull(message= "Veuillez renseigner le numéro de voie !")
    private Integer number;

    @NotNull(message= "Veuillez renseigner le nom de la voie !")
    private String street;

    @NotNull(message= "Veuillez renseigner votre code postal !")
    private String postalCode;

    @NotNull(message= "Veuillez renseigner le nom de votre ville !")
    private String city;

    private String information;

    private Boolean delivery;

    private Boolean billing;
}
