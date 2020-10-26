package fr.openclassroom.epicerie.back.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_commande")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "t_user", nullable = false)
    @NotNull(message="L'utilisateur ne peut pas être null")
    private User user;

    @OneToOne(mappedBy = "commande", optional = false)
    @NotNull(message="Le panier ne peut pas être null")
    private Panier panier;

    @NotNull(message= "La date ne peut être null")
    private Date date;

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
