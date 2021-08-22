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
@Table(name= "t_order_adress")
public class OrderAdress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    private String appartNumber;

    private String interphone;

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
