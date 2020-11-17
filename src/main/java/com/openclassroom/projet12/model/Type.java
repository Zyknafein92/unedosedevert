package com.openclassroom.projet12.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name= "t_type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message= "Veuillez définir un nom ! (ex: Alimentaire, Cosmétique...)")
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Categorie> categories;
}



