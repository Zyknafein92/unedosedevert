package com.openclassroom.projet12.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_variant_order")
public class VariantOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long variantID;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    private Integer quantity;

    @NotNull(message= "Veuillez renseigner un prix pour le variant!")
    private Double price;

    @NotNull(message= "Veuillez renseigner un prix au kg pour le variant!")
    private Double priceKg;

    private Double reductionPrice;

    public Double calculateTotalPrice () {
        return quantity * price;
    }
}
