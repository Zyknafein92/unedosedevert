package fr.openclassroom.epicerie.back.model;

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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "panier_id")
    @NotNull(message= "Erreur, le panier ne peut pas être null !")
    private Panier panier;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produit_id")
    @NotNull(message= "Erreur, le produit ne peut pas être null !")
    private Produit produit;

    @NotNull(message= "Veuillez renseigner la quantité du produit !")
    private Integer quantity;

    @NotNull(message= "Veuillez renseigner le prix du produit !")
    private Double prix;
}
