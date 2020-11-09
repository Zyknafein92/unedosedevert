package com.openclassroom.projet12.model;

import lombok.Getter;

@Getter
public enum Stock {
    DISPONIBLE("Produit en stock"),
    STOCK_FAIBLE("Stock faible, réapprovisionnement en cours"),
    REAPPROVISIONNEMENT("Produit indisponible pour le moment");

    private final String description;

    Stock(String description) {
        this.description = description;
    }
}
