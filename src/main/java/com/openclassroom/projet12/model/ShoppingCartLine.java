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
@Table(name = "t_shopping_cart_line")
public class ShoppingCartLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variant_id")
    @NotNull(message= "Erreur, le variant du product ne peut pas être null !")
    private Variant variant;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produit_id")
    @NotNull(message= "Erreur, le product ne peut pas être null !")
    private Product product;

    @NotNull(message= "Veuillez renseigner la quantité du product !")
    private Integer quantity;

    @NotNull(message= "Veuillez renseigner le prix du product !")
    private Double price;
}
