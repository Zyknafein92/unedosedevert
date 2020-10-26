package com.openclassroom.projet12.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "t_panier_ligne")
public class PanierLigne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produit_id")
    @NotNull(message= "Erreur, le produit ne peut pas être null !")
    private Produit produit;

    @NotNull(message= "Veuillez renseigner la quantité du produit !")
    private Integer quantity;

    @NotNull(message= "Veuillez renseigner le prix du produit !")
    private Double prix;
}
