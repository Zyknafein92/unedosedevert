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
@Table(name = "t_tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Veuillez renseigner un nom pour le tag !")
    private String name;

    @NotNull(message = "Veuillez renseigner une description pour le tag !")
    private String description;
}
