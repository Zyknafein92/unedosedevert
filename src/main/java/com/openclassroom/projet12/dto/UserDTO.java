package com.openclassroom.projet12.dto;
import com.openclassroom.projet12.model.Role;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Builder
public class UserDTO {

    private Long id;

    private List<AdresseDTO> adresses;

    private PanierDTO panier;

    private List<CommandeDTO> commandesCommandes;

    private Set<Role> roles;

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
