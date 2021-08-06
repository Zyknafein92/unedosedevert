package com.openclassroom.projet12.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message="L'utilisateur ne peut pas être null")
    private User user;

    @OneToOne
    private Adress deliveryAdress;

    @OneToOne
    private Adress billingAdress;

    @OneToMany(cascade = CascadeType.ALL)
    @NotNull(message= "La commande doit posséder au moins un product")
    private List<VariantOrder> variantOrderList;

    private Double deliveryCharges;

    @NotNull(message= "Erreur, le prix total doit être affiché")
    private Double total;

    @NotNull(message= "La date ne peut être null")
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
