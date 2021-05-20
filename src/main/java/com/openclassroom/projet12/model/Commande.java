package com.openclassroom.projet12.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_commande")
public class Commande {

    //todo: Ajouter List<Variant> Juste une copie avec infos importantes. Vérifier les paniers des utilisateurs et supprimer les éléments.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message="L'utilisateur ne peut pas être null")
    private User user;

    @OneToMany
    private List<Variant> variantList;

    @NotNull(message= "La date ne peut être null")
    private LocalDateTime date;

    @NotNull(message= "Erreur, le prix total doit être affiché")
    private Double total;

    @Enumerated(EnumType.STRING)
    @NotNull(message= "Le status de la commande ne peut être null")
    private StatusCommande statusCommande;

    @Enumerated(EnumType.STRING)
    @NotNull(message= "Veuillez choisir un mode de règlement")
    private ModeReglement modeReglement;

    @NotNull(message= "Un choix de retrait doit être sélectionné")
    private Boolean livraison;
}
