package com.openclassroom.projet12.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_reduction")
public class Reduction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.DETACH)
    private Produit produit;

    private Double pourcentageRemise;

    private LocalDate reductionStart;

    private LocalDate reductionEnd;
}
