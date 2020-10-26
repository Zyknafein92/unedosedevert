package fr.openclassroom.epicerie.back.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "t_panier")
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "commande_id")
    private Commande commande;

    @OneToMany(mappedBy = "panier")
    private List<PanierLigne> panierLigne;

    private Double prixTotal;

}
