package com.openclassroom.projet12.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_variant")
public class Variant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageURL;

    private Double prix;

    private Double tva;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    private Reduction reduction;

    @Enumerated(EnumType.STRING)
    @NotNull(message= "Veuillez renseigner la disponibilitée du produit !")
    private Stock stock;
}
