package com.openclassroom.projet12.model;

import lombok.Getter;


@Getter
public enum Type {
    ALIMENTAIRE("Alimentaire"),
    COSMETIQUE("Cosmetique"),
    HYGIENE("Hygiène"),
    ENTRETIENT("Produit d'entretient");

    private final String description;

    Type(String description) {
        this.description = description;
    }
}


