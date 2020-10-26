package fr.openclassroom.epicerie.back.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


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

    @NotNull(message= "Veuillez renseigner votre nom !")
    private String nom;

    @NotNull(message= "Veuillez renseigner votre prénom !")
    private String prenom;

    @NotNull(message= "Veuillez renseigner une date de naissance !")
    private Date anniversaire;

    @NotNull(message= "Veuillez renseigner un numéro de téléphone !")
    private String telephone;

    @NotNull(message= "Veuillez renseigner un email !")
    private String email;

    @NotNull(message = "Veuillez renseigner un mot de passe !")
    private String password;

}
