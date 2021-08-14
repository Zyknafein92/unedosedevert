package com.openclassroom.projet12.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name= "t_user")
public class  User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Adress> adresses = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private ShoppingCart shoppingCart;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @NotNull(message= "Veuillez renseigner votre sexe !")
    private String gender;

    @NotNull(message= "Veuillez renseigner votre nom !")
    private String lastName;

    @NotNull(message= "Veuillez renseigner votre prénom !")
    private String firstName;

    @NotNull(message= "Veuillez renseigner une date de naissance !")
    private LocalDate birthday;

    @NotNull(message= "Veuillez renseigner un email !")
    @Column(unique = true)
    private String email;

    @NotNull(message = "Veuillez renseigner un mot de passe !")
    private String password;

    private String forgotPasswordToken;

    private LocalDateTime forgotPasswordTokenExpiration;

    // pour pouvoir désactiver un compte si besoin
    private Boolean active;

    private Boolean newsletter;

}
